package com.example.jobfinder.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.jobfinder.R;

public class MainActivity extends AppCompatActivity {
    private Button view_cvs_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view_cvs_button = (Button) findViewById(R.id.view_cvs_button);

    }

    public void view_cvs(View view) {
        Intent intent = new Intent(this, CVListActivity.class);
        startActivity(intent);
    }
}