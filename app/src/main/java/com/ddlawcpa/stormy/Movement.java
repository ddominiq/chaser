package com.ddlawcpa.stormy;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.Button;

/**
 * Created by davidd on 4/16/2016.
 */
public class Movement {

    private float location = 0;
    private String viewProp;
    private Button mMoveButton;
    public ObjectAnimator animX;



    Movement(Button b){
        mMoveButton = b;

    }

    public void onClick(String s, float f) {

        location = f;
        viewProp = s;

        animX = ObjectAnimator.ofFloat(mMoveButton, viewProp, location);
        animX.start();

        // set listener to update the location

        AnimatorListenerAdapter AnListener = new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                location += -50;
            }
        };

        // call addListener
        animX.addListener(AnListener);

    }
}
