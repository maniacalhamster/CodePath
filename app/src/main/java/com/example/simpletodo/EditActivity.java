package com.example.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    EditText etItem;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        etItem = findViewById(R.id.etItem);
        btnSave= findViewById(R.id.btnSave);

        getSupportActionBar().setTitle("Edit Item");
        etItem.setText(getIntent().getStringExtra(MainActivity.KEY_ITEM_TEXT));

        // once etItem has been set, user presses save
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1) Create intent and fill with results
                Intent intent = new Intent();
                // 2) pass data (results of editing)
                intent.putExtra(MainActivity.KEY_ITEM_TEXT, etItem.getText().toString());
                intent.putExtra(MainActivity.KEY_ITEM_POSITION, getIntent().getExtras().getInt(MainActivity.KEY_ITEM_POSITION));
                // 3) set result of intent
                setResult(RESULT_OK, intent);
                // 4) finish activity to close screen and go back to prev activity
                finish();
            }
        });
    }
}