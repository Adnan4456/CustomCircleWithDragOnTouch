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


     var mCircleX = 0f

    private var mCircleY = 0f

    private var radius = 200f


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
//        canvas!!.translate(width/2f , height/2f)

        //Position circle to center of view
        if (mCircleX == 0f || mCircleY == 0f){
            mCircleX = width /2f
            mCircleY = height /2f
        }

        canvas!!.drawCircle(mCircleX , mCircleY , radius,paint )
    }


    override fun onTouchEvent(event: MotionEvent?): Boolean {
//        return super.onTouchEvent(event)
        var value:Boolean = super.onTouchEvent(event)

        when(event!!.action){

            //we need to detect the ACTION_DOWN.Meadn screen is touched
                //otherwise ACTION_MOVE will not called
            MotionEvent.ACTION_DOWN ->{

                //getting touch points on view
                var fX = event.x
                var fY = event.y


                return true
            }
        

            MotionEvent.ACTION_MOVE -> {

                //getting touch points on view
                var fX = event.x
                var fY = event.y

                //Check that touch is on Circle or not.
                var dx = Math.pow(fX.toDouble() - mCircleX , 2.0)
                var dy = Math.pow(fY.toDouble() - mCircleY , 2.0)

                if (dx + dy < Math.pow(radius.toDouble() , 2.0))
                {
//                  your circle is touched
                    mCircleX = fX
                    mCircleY = fY

                    //Now increase the size of circle on touch
                    radius = 400f

                    //show these changes call
                    postInvalidate()
                    return true

                }
                return value
            }
        }

        return value
    }
}