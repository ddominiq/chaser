package com.ddlawcpa.stormy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_NANE = "MyPrefsFile";
    private EditText mAgeEditText;
    private EditText mNameEditText;
    private Button mSubscribeButton;

    String FILENAME = "hello_file";
    String string = "hello world!";



    public static final String TAG = MainActivity.class.getSimpleName();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_WORLD_READABLE);
            fos.write(string.getBytes());
            fos.close();
            Log.d(TAG, "It worked");
        } catch(IOException e){
            e.printStackTrace();
            Log.d(TAG, "It didn't work");
        }

        try {
            FileInputStream fis = openFileInput(FILENAME);
            int fileRead = fis.read();
            fis.close();
            Log.d(TAG, fileRead + " Input worked");
        } catch(IOException e){
            Log.d(TAG, "Input didn't work");
        }

        mAgeEditText = (EditText) findViewById(R.id.ageEditText);
        mNameEditText = (EditText) findViewById(R.id.nameEditText);
        mSubscribeButton = (Button) findViewById(R.id.subscribeButton);
        final Intent intent = new Intent (this, SecondActivity.class);
        mSubscribeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }
}


