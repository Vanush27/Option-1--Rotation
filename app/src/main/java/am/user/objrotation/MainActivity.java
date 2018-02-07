package am.user.objrotation;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView circle;
    private double mCurrAngle = 0;
    ViewGroup mRelativeLayout;

    private GestureDetector mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        circle = findViewById(R.id.imageView);
        mRelativeLayout = findViewById(R.id.relativeLayout);

        //noinspection deprecation
        mGestureDetector = new GestureDetector(new HorizontalGestureListener(new HorizontalGestureListener.SwipeDirection() {
            @Override
            public void horizontal(float velocity) {
                mCurrAngle =Math.round(Math.floor(velocity));
                animate((float)Math.toDegrees( mCurrAngle));
            }
        }));

        mRelativeLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                Toast.makeText(MainActivity.this, "DEG:" + mCurrAngle, Toast.LENGTH_SHORT).show();
                return mGestureDetector.onTouchEvent(event);
            }
        });
    }

    private void animate(float toDegrees) {
        ObjectAnimator.ofFloat(circle,
                "rotation",
                circle.getRotation(),
                circle.getRotation() + toDegrees)
                .setDuration((long) 0)
                .start();
    }
}
