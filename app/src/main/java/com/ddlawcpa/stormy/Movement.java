package com.ddlawcpa.stormy;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

/**
 * Created by davidd on 4/16/2016.
 */
public class Movement {

    private float location = 0;
    private String viewProp;
    private Button mMoveButton;
    private TextView mYposition;
    private TextView mXposition;

    public ObjectAnimator animation;



    Movement(Button b){
        mMoveButton = b;

    }

    public void onClick(String s, float f) {

        location = f;
        viewProp = s;

        animation = ObjectAnimator.ofFloat(mMoveButton, viewProp, location);
        animation.setDuration(2000);
        animation.start();


    }

    public void killIt(){

        Movement.this.animation.cancel();
/*        ValueAnimator.AnimatorUpdateListener stopUpdateListener = new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Movement.this.animation.cancel();

            }
        }; */
    }


    public void getPosition(TextView x, TextView y){
        mXposition = x;
        mYposition = y;
        ValueAnimator.AnimatorUpdateListener positionUpdateListener = new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                    String mXvalue = Movement.this.animation.getAnimatedValue().toString();
                    String mYvalue = Movement.this.animation.getAnimatedValue().toString();

                    mXposition.setText(mXvalue);
                    mYposition.setText(mYvalue);

            }
        };
        this.animation.addUpdateListener(positionUpdateListener);
    }


}
