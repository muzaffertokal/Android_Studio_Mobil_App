package com.kotele.runnablehandler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    int number;
    Runnable runnable; //bir işlemi birden fazla kez belirtilen periyotta veya sayıda yapılmasını sağlayan arayüz.
    Handler handler; // ele almak,yönetmek runnable'ı ele alan yönetmeyi sağlayan bir arayüz.
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            textView = findViewById(R.id.textView);
            button = findViewById(R.id.button);
            number = 0;

    }
    public void start (View view){
        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() { //run metodunda yazılan herşey belirtilen periyot(sayı veya süre) içinde gerçekleşecek.
                textView.setText("Time: " + number);
                number++;
                textView.setText("Time: " + number);
                handler.postDelayed(runnable,1000);
                button.setEnabled(false); //Start butonu bir kez tıklandıktan sonra kullanılamaz hale geldi.

            }
        };
        handler.post(runnable);

    }
    public void stop (View view){
        
        button.setEnabled(true);//stop butonuna tıkladığımızda, start butonumuz tekrar aktif (tıklanır) hale geldi.
        handler.removeCallbacks(runnable); //runnable kapatma işlemi
        number = 0;
        textView.setText("Time: 0" + number); // runnable kapatma işleminden sonra numarayı sıfırlama işlemi.

    }
}