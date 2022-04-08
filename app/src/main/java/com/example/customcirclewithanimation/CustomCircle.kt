package com.example.customcirclewithanimation

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.annotation.Nullable

class CustomCircle: View {

    private lateinit var paint: Paint


     val x = width

    private var y = height

    private var radius = 200

    constructor(context: Context) : super(context){
        init(null)
    }

    constructor(context: Context, attrs: AttributeSet): super(context , attrs){
        init(attrs)

    }
    constructor(context: Context, attrs: AttributeSet, defStyleAttr:Int):
            super(context , attrs , defStyleAttr){
        init(attrs)
    }

    private fun init(@Nullable set: AttributeSet?){

        //        Paint.ANTI_ALIAS_FLAG is flag that is more user friendly

        paint = Paint(Paint.ANTI_ALIAS_FLAG)
//        Paint.ANTI_ALIAS_FLAG is flag that is more user friendly

        //setting color to rectangle
        paint.setColor(Color.RED)
    }

    override fun onDraw(canvas: Canvas?) {

//        if you want to draw circle at centre.
//        You could also translate your entire canvas to
//        center then draw circle at center.using
        canvas!!.translate(width/2f , height/2f)
        canvas!!.drawCircle(x.toFloat()/2 , y.toFloat()/2 , radius.toFloat(),paint )
    }
}