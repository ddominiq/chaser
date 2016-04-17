package com.ddlawcpa.stormy;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by davidd on 4/16/2016.
 */
public class DPad {

    private Button mChasedButton;
    private Button mUpButton;
    private Button mDownButton;
    private Button mLeftButton;
    private Button mRightButton;
    private Button mStopButton;
    private TextView mXposition;
    private TextView mYposition;


    // Constructor
    DPad(Button c, Button u, Button d, Button l, Button r, Button s){

        mChasedButton = c;
        mUpButton = u;
        mDownButton = d;
        mLeftButton = l;
        mRightButton = r;
        mStopButton = s;



    }

    // Moves the button



    public void move(TextView x, TextView y){

        mXposition = x;
        mYposition = y;
        String xPosition;
        String yPosition;

        final Movement mover = new Movement(mChasedButton);


        View.OnClickListener clickLeft = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mover.onClick("x", -50F);
                mover.getPosition(mXposition, mYposition);
            }
        };


        View.OnClickListener clickRight = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mover.onClick("x", 1000F);
                mover.getPosition(mXposition, mYposition);
            }
        };

        View.OnClickListener clickUp = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mover.onClick("y", -50F);
                mover.getPosition(mXposition, mYposition);
            }
        };

        View.OnClickListener clickDown = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mover.onClick("y",1000F);
                mover.getPosition(mXposition, mYposition);
            }
        };

        View.OnClickListener clickStop = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mover.killIt();
            }
        };



        mUpButton.setOnClickListener(clickUp);
        mDownButton.setOnClickListener(clickDown);
        mLeftButton.setOnClickListener(clickLeft);
        mRightButton.setOnClickListener(clickRight);
        mStopButton.setOnClickListener(clickStop);




    }



}
