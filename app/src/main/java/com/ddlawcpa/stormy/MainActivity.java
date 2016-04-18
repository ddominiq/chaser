package com.ddlawcpa.stormy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mGameButton;
    private Button mAppButton;
    private Button mFragButton;


    public static final String TAG = MainActivity.class.getSimpleName();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGameButton = (Button) findViewById(R.id.gameButton);
        mAppButton = (Button) findViewById(R.id.appButton);
        mFragButton = (Button) findViewById(R.id.fragmentButton);


        View.OnClickListener gameListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent game = new Intent(MainActivity.this, Splash.class);
                startActivity(game);
            }
        };

        View.OnClickListener appListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent app = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(app);
            }
        };

        View.OnClickListener fragListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent frag = new Intent(MainActivity.this, fragActivity.class);
                startActivity(frag);
            }
        };

        mGameButton.setOnClickListener(gameListener);
        mAppButton.setOnClickListener(appListener);
        mFragButton.setOnClickListener(fragListener);

    }
}


