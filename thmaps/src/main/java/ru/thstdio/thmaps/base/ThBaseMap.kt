package ru.thstdio.thmaps.base

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.OnLifecycleEvent
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.widget.FrameLayout


abstract class ThBaseMap : FrameLayout, IThMap, LifecycleObserver {
    var onPointClick: onThMapPointClickListener? = null
    var onMapReady: OnThMapReady? = null

    constructor(context: Context) : super(context) {
        init(context)
    }


    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(
        context,
        attrs,
        defStyleAttr,
        defStyleRes
    ) {
        init(context)
    }

    abstract fun init(context: Context)

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onAny(source: LifecycleOwner, event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_START -> {
                Log.d("ThMap", "Lifecycle.Event.ON_START")
            }
            Lifecycle.Event.ON_PAUSE -> Log.d("ThMap", "Lifecycle.Event.ON_PAUSE")
            Lifecycle.Event.ON_CREATE -> Log.d("ThMap", "Lifecycle.Event.ON_START")
            Lifecycle.Event.ON_STOP -> Log.d("ThMap", "Lifecycle.Event.ON_STOP")
            Lifecycle.Event.ON_RESUME -> Log.d("ThMap", "Lifecycle.Event.ON_RESUME")
        }
    }

}