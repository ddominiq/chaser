package com.ddlawcpa.stormy;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


public class Splash extends Activity {


    private Button mDownButton;
    private Button mLeftButton;
    private Button mRightButton;
    private Button mUpButton;
    private Button mChasedButton;
    private Button mStopButton;
    private TextView mYposition;
    private TextView mXposition;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email);

        mDownButton = (Button) findViewById(R.id.downButton);
        mLeftButton = (Button) findViewById(R.id.leftButton);
        mRightButton = (Button) findViewById(R.id.rightButton);
        mUpButton = (Button) findViewById(R.id.upButton);
        mChasedButton = (Button) findViewById(R.id.chasedButton);
        mStopButton = (Button) findViewById(R.id.stopButton);
        mYposition = (TextView) findViewById(R.id.yPositionText);
        mXposition = (TextView) findViewById(R.id.xPositionText);

        DPad controller = new DPad(mChasedButton, mUpButton, mDownButton, mLeftButton, mRightButton, mStopButton);

        controller.move(mXposition, mYposition);

        mXposition.setText("hey");



    }
}
