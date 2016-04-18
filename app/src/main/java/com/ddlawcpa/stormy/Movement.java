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

    private float start = 0;
    private float stop = 0;
    private String viewProp;
    private Button mMoveButton;
    private TextView mYposition;
    private TextView mXposition;

    public ObjectAnimator animation;



    Movement(Button b){
        mMoveButton = b;

    }
    public void onClick(String s, int direction) {
        viewProp = s;

        animation = ObjectAnimator.ofFloat(mMoveButton, viewProp, start, stop);

        // int refers to direction; 0 = up; 1 = down; 2 = left= 3 = right

        switch (direction){
            case 0:
                start -= (float)this.animation.getAnimatedValue("translationY");

                Float stop1 = (float) this.animation.getAnimatedValue("translationY");
                stop = stop1 - 100;
                break;
            case 1:
                start += 100;
                stop1 = (float) this.animation.getAnimatedValue("translationX");
                stop = stop1 + 100;
                break;

            case 2:
                start -= 200;
                stop1 = (float) this.animation.getAnimatedValue("translationY");
                stop = stop1 - 100;
                break;
            case 3:
                start += 100;
                stop1 = (float) this.animation.getAnimatedValue("translationY");
                stop = stop1 + 100;
                break;
        }

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
