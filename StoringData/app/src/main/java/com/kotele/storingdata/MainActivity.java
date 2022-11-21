package com.kotele.storingdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SharedMemory;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    EditText editText;
    TextView textView;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextNumber);
        textView = findViewById(R.id.textView);


        // SharedPreferences : Çok küçük verileri telefon hafızasında saklamak için oluşturulan obje.
        //this : Objeye ulaşmamızı sağlar.


        sharedPreferences = this.getSharedPreferences("com.kotele.storingdata", Context.MODE_PRIVATE);

        int storedAge = sharedPreferences.getInt("storedAge", 0);

        if (storedAge == 0) {
            textView.setText("Your age: ");
        } else {
            textView.setText("Your age: " + storedAge);

            // MOD_PRIVATE : Saklanan mini veritabanına yalnızca bu uygulamadan erişim sağlar.
            // Context : Mod'a ulaşmamızı sağlıyor.

        }

    }
        public void save (View view ) {

            if (!editText.getText().toString().matches("")) {
                int userAge = Integer.parseInt(editText.getText().toString());
                textView.setText("Your age: " + userAge);


                sharedPreferences.edit().putInt("storedAge", userAge).apply();
            }



            }
            public void delete (View view ) {
                int storeData = sharedPreferences.getInt("storedAge",0);
                    if (storeData !=0) {
                        sharedPreferences.edit().remove("storedAge").apply();
                        textView.setText("Your age: ");

                }


            }

        }






















