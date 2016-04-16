package com.ddlawcpa.stormy;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Splash extends Activity {


    private Button mDownButton;
    private Button mLeftButton;
    private Button mRightButton;
    private Button mUpButton;
    private Button mChasedButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email);

        mDownButton = (Button) findViewById(R.id.downButton);
        mLeftButton = (Button) findViewById(R.id.leftButton);
        mRightButton = (Button) findViewById(R.id.rightButton);
        mUpButton = (Button) findViewById(R.id.upButton);
        mChasedButton = (Button) findViewById(R.id.chasedButton);

        DPad controller = new DPad(mChasedButton, mUpButton, mDownButton, mLeftButton, mRightButton);

        controller.move();




    }
}
