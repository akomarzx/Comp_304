package com.ronald.ombao.activity

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView

class CustomImageViewForZigZag(context: Context, attrs: AttributeSet? = null) :
    AppCompatImageView(context, attrs) {

    private val paint = Paint()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawColor(Color.MAGENTA)

        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 10f
        paint.color = Color.WHITE

        val middlePointY : Float = height / 2f
        val zigZagHeight : Float = height / 3f
        var currentIncrement : Float = 1f

        val zigZagWidth = 12f

        var currentXStart = 0f
        var currentXStop : Float = (width / zigZagWidth) * currentIncrement

        while (currentXStop <= width) {

            canvas.drawLine(currentXStart, middlePointY, currentXStop, zigZagHeight, paint)

            currentXStart = (width / zigZagWidth) * currentIncrement
            ++currentIncrement
            currentXStop = (width / zigZagWidth) * currentIncrement

            canvas.drawLine(currentXStart, zigZagHeight, currentXStop, middlePointY, paint)

            currentXStart = (width / zigZagWidth) * currentIncrement
            ++currentIncrement
            currentXStop = (width / zigZagWidth) * currentIncrement
        }

    }
}