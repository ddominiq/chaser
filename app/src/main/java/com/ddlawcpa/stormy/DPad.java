package com.ddlawcpa.stormy;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.Button;

/**
 * Created by davidd on 4/16/2016.
 */
public class DPad {

    private Button mChasedButton;
    private Button mUpButton;
    private Button mDownButton;
    private Button mLeftButton;
    private Button mRightButton;
    private float startX = 0;
    private float startY = 0;


    // Constructor
    DPad(Button c, Button u, Button d, Button l, Button r){

        mChasedButton = c;
        mUpButton = u;
        mDownButton = d;
        mLeftButton = l;
        mRightButton = r;



    }

    // Moves the button



    public void move(){



        final Movement mover = new Movement(mChasedButton);

        View.OnClickListener clickLeft = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mover.onClick("x", -50F);
            }

        };

        View.OnClickListener clickRight = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mover.onClick("x", 1000F);
            }
        };

        View.OnClickListener clickUp = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mover.onClick("y", -50F);
            }
        };

        View.OnClickListener clickDown = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mover.onClick("y",1000F);
            }
        };

        mUpButton.setOnClickListener(clickUp);
        mDownButton.setOnClickListener(clickDown);
        mLeftButton.setOnClickListener(clickLeft);
        mRightButton.setOnClickListener(clickRight);















    }


    Animator.AnimatorListener listener = new AnimatorListenerAdapter() {
        @Override
        public void onAnimationEnd(Animator animation) {
            super.onAnimationEnd(animation);

        }
    };

}
