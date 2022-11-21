package com.kotele.multiactivitydisplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String userName;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextTextPersonName);
        userName = " ";



    }
    public void changeActivity(View view) {

        userName = editText.getText().toString();

        Intent intent = new Intent(MainActivity.this,MainActivity2.class);

        //putExtra ile aktiviteler arası bilgi aktarımı yapılıyor.

        intent.putExtra("userInput",userName);

        startActivity(intent);





    }
}