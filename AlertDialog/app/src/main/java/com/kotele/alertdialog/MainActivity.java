package com.kotele.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(MainActivity.this,"Toast Message",Toast.LENGTH_LONG).show();

        //
    }
    public void save (View view){

        // AlertDialog.Builder Uyarı mesajı vermemizi sağlıyor.

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Save"); //Uyarı mesajımızın başlığını belirttik.
        alert.setMessage("Are you sure?"); //Uyarı mesajımızın içeriğini belirttik.
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //kaydetme (save) işlemi


                Toast.makeText(MainActivity.this,"Saved",Toast.LENGTH_LONG).show();


            }
        });

        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Toast.makeText(MainActivity.this," Not Saved",Toast.LENGTH_LONG).show();
            }
        });
        //DialogInterface.OnClick-Listener: Bir şeye dokunulduğunda veya bir olay olduğunda ne olacağını ne yazacağımızı belirttiğimiz dinleyici arayüz.


        alert.show();



    }
}