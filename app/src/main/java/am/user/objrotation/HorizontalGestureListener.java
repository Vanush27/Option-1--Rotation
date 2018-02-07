package am.user.objrotation;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * Created by Vanush all rights reserved.
 */

public class HorizontalGestureListener extends GestureDetector.SimpleOnGestureListener {
    private SwipeDirection mSwipeDirection;

    public interface SwipeDirection {
        void horizontal(float velocity);
    }

    public HorizontalGestureListener(SwipeDirection swipeDirection) {
        mSwipeDirection = swipeDirection;
    }

    @Override
    public boolean onDown(MotionEvent event) {
        Log.d("TAG", "onDown: ");
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        Log.i("TAG", "onSingleTapConfirmed: ");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        Log.i("TAG", "onLongPress: ");
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        Log.i("TAG", "onDoubleTap: ");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Log.i("TAG", "onScroll: " + distanceX + " " + distanceY);
        if (Math.abs(distanceX) > Math.abs(distanceY)) {
            mSwipeDirection.horizontal(distanceX);
            return true;
        }
        return true;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return true;
    }

}