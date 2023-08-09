package com.example.demo1

import android.R.attr.x
import android.R.attr.y
import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.GestureDescription
import android.accessibilityservice.GestureDescription.StrokeDescription
import android.content.Intent
import android.graphics.Path
import android.os.SystemClock
import android.util.Log
import android.view.KeyEvent
import android.view.KeyEvent.ACTION_DOWN
import android.view.KeyEvent.ACTION_UP
import android.view.KeyEvent.KEYCODE_VOLUME_DOWN
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityEvent.TYPE_VIEW_SCROLLED
import android.view.accessibility.AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED
import android.view.accessibility.AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED
import androidx.compose.foundation.Canvas


class MyAccessibilityService : AccessibilityService() {
    //val TAG: String = "LOG"

    override fun onServiceConnected() {
        //Log.i(TAG, "onServiceConnected")
        super.onServiceConnected()
    }

    override fun onUnbind(intent: Intent?): Boolean {
        //Log.i(TAG, "onUnbind")
        return super.onUnbind(intent)
    }

    override fun onInterrupt() {
    }

    override fun onKeyEvent(event: KeyEvent): Boolean {
        //Log.i(TAG, "${event.toString()}")
        if (event.action == ACTION_UP && event.keyCode == KEYCODE_VOLUME_DOWN) {
            var n = GlobalVariables.num
            while (n > 0) {
                //Log.i(TAG,"${n}")
                n -= 1
                var flag = GlobalVariables.flag
                if (flag > 0) {
                    //Log.i(TAG,"draw a line")

                    touchscreen(
                        GlobalVariables.PointX, GlobalVariables.PointY,
                        GlobalVariables.PointX, GlobalVariables.PointY,
                        GlobalVariables.Stime, GlobalVariables.Duratin
                    )
                    SystemClock.sleep(GlobalVariables.timeout)
                    touchscreen(
                        GlobalVariables.FromX, GlobalVariables.FromY,
                        GlobalVariables.ToX, GlobalVariables.ToY,
                        GlobalVariables.Stime, GlobalVariables.Duratin
                    )
                    SystemClock.sleep(GlobalVariables.timeout)
                } else {
                    break
                }
            }
        }
        return super.onKeyEvent(event)
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        //Log.i(TAG, "${event.toString()}")
    }

//    override fun onAccessibilityEvent(event: AccessibilityEvent) {
//        if(event.eventType == TYPE_WINDOW_CONTENT_CHANGED ||
//            event.eventType == TYPE_WINDOW_STATE_CHANGED){
//            return
//        }
//
//        Log.i(TAG, "${event.toString()}")
//
//        event.packageName?.apply{
//            Log.i(TAG,event.packageName.toString())
//        }
//
//        if(event.eventType == TYPE_VIEW_SCROLLED) {
//            GlobalVariables.stat = 0
//            var x = GlobalVariables.num
//            while(x>0){
//                GlobalVariables.stat += 1
//                x-=1
//                var flag = GlobalVariables.flag
//                if(flag > 0) {
//                    doDownDrag(GlobalVariables.FromX,GlobalVariables.FromY,
//                        GlobalVariables.ToX, GlobalVariables.ToY,
//                        GlobalVariables.Stime,GlobalVariables.Duratin)
//                }
//                else
//                {
//                    return
//                }
//            }
    //      }
//}

    private fun touchscreen(
        fromX: Float,
        fromY: Float,
        toX: Float,
        toY: Float,
        stime: Long,
        duration: Long
    ) {
        val path = Path()
        path.moveTo(fromX, fromY)
        path.lineTo(toX, toY)

        val builder = GestureDescription.Builder()
        builder.addStroke(StrokeDescription(path, GlobalVariables.Stime, GlobalVariables.Duratin))
        val gestureDescription = builder.build()
        dispatchGesture(gestureDescription, null, null)
    }
}