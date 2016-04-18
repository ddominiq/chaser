package com.ddlawcpa.stormy;

import android.content.ClipData;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private Button mHomeButton;
    private TextView mDragMe;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        mHomeButton = (Button) findViewById(R.id.homeButton);
        mDragMe = (TextView) findViewById(R.id.dragTextView);

        mDragMe.setTag("here is my tag");


        mHomeButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {


                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(v);

                v.startDrag(ClipData.newPlainText("label", "text that is sent"), myShadow,null,0);

                return true;
            }
        });



        mDragMe.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {

                String coordinates = "x: " + Float.toString((mDragMe.getX())) + "\nY: " + Float.toString((mDragMe.getY()));
                mDragMe.setText(coordinates);

                return true;
            }
        });



        mHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goHome = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(goHome);
            }
        });





    }


}
