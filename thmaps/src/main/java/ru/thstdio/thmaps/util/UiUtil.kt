package ru.thstdio.thmaps.util

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.support.annotation.DrawableRes
import android.support.v4.content.ContextCompat

class UiUtil {
    companion object {
        fun drawableToBitmap(
            context: Context,
            @DrawableRes drawableRes: Int
        ): Bitmap? {
            val drawable = ContextCompat.getDrawable(context, drawableRes)
            val w = drawable!!.intrinsicWidth
            val h = drawable.intrinsicHeight
            var bitmap: Bitmap? = null
            try {
                bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
                val canvas = Canvas(bitmap!!)
                drawable.setBounds(0, 0, w, h)
                drawable.draw(canvas)
                return bitmap
            } catch (e: OutOfMemoryError) {
                // TODO:
            }

            return bitmap
        }
    }


}
