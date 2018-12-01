package com.kausthubh.basis.home.views

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.animation.DecelerateInterpolator
import com.kausthubh.basis.R
import com.kausthubh.basis.home.adapter.viewholder.CardAdapter
import com.kausthubh.basis.misc.custom.OnSwipeTouchListener
import com.kausthubh.basis.misc.utils.MiscUtils
import com.yuyakaido.android.cardstackview.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), CardStackListener {

    lateinit var layoutManager: CardStackLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    /**
     * Everthing related to setting up the application.
     *
     */
    private fun initViews() {
        val rewindSetting = RewindAnimationSetting.Builder()
            .setDirection(Direction.Top)
            .setDuration(200)
            .setInterpolator(DecelerateInterpolator())
            .build()

        layoutManager = CardStackLayoutManager(applicationContext, this)
        val adapter = CardAdapter()
        layoutManager.setDirections(arrayListOf(Direction.Right, Direction.Left))
        layoutManager.setCanScrollHorizontal(true)
        layoutManager.setVisibleCount(5)
        layoutManager.setStackFrom(StackFrom.Bottom)
        layoutManager.setTranslationInterval(5f)
        layoutManager.setRewindAnimationSetting(rewindSetting)
        layoutManager.setCanScrollVertical(false)
        layoutManager.setMaxDegree(90f)
        cards.layoutManager = layoutManager
        cards.adapter = adapter
        handleChanges()

        // Button Interactions
        restack.setOnClickListener {
            if (layoutManager.topPosition != 0) {
                cards.smoothScrollToPosition(0)
            }
        }

        previousCard.setOnClickListener {
            cards.rewind()
        }

        container.setOnTouchListener(object : OnSwipeTouchListener(this@MainActivity) {
            override fun onSwipeDown() {
                cards.rewind()
            }
        })

    }

    override fun onCardRewound() {
        handleChanges()
    }

    override fun onCardCanceled() {

    }

    override fun onCardDragging(direction: Direction?, ratio: Float) {

    }

    override fun onCardSwiped(direction: Direction?) {
        handleChanges()
    }


    /**
     * Handle visibility and miscellanous things when cards are swiped.
     */
    fun handleChanges() {
        progressBar.progress = MiscUtils().calculatePercentage(layoutManager.topPosition, layoutManager.itemCount)
        if (layoutManager.topPosition == 0) {
            restack.hide()
            previousCard.visibility = View.GONE
        } else {
            restack.show()
            previousCard.visibility = View.VISIBLE
        }
    }

}


