package com.ddlawcpa.stormy;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

    public String onClick(String s, float f) {

        location = f;
        viewProp = s;

        animation = ObjectAnimator.ofFloat(mMoveButton, viewProp, location);
        animation.setDuration(2000);
        animation.start();
        return animation.getAnimatedValue().toString();
    }

    public void killIt(){
        animation.end();
    }

    public void getPosition(TextView x, TextView y){

        mXposition = x;
        mYposition = y;
        ValueAnimator.AnimatorUpdateListener listenerX = new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mXposition.setText(animation.getAnimatedValue().toString());
                mYposition.setText(animation.getAnimatedValue().toString());

            }


        };
        this.animation.addUpdateListener(listenerX);
    }


}
