package com.example.fansclubpenguin;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class FansClubPenguinActivity extends AppCompatActivity  implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fans_club_penguin);
        findViewById(R.id.btn_toast).setOnClickListener(this);
        findViewById(R.id.btn_maps).setOnClickListener(this);
        findViewById(R.id.btn_phone).setOnClickListener(this);
        findViewById(R.id.btn_web).setOnClickListener(this);
        findViewById(R.id.btn_email).setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btn_toast:
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Присоединяйся :)", Toast.LENGTH_LONG);
                toast.show();
                break;
            case R.id.btn_maps:
                String geoUriString = "geo:0,0?q= ekreative, Черкассы";
                Uri geo = Uri.parse(geoUriString);
                Intent geoIntent = new Intent(Intent.ACTION_VIEW, geo);
                startActivity(geoIntent);
                break;
            case R.id.btn_phone:
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+380123456789"));
                startActivity(intent);
                break;
            case R.id.btn_web:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ru.wikipedia.org/wiki/%D0%9F%D0%B8%D0%BD%D0%B3%D0%B2%D0%B8%D0%BD%D0%BE%D0%B2%D1%8B%D0%B5"));
                startActivity(intent);
                break;
            case R.id.btn_email:
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","vika.shvets1999@gmail.com",null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Ваш вопрос");
                emailIntent.putExtra(Intent.EXTRA_TEXT,"Напишите здесь то, что Вас интересует");
                startActivity(Intent.createChooser(emailIntent,"Email"));
                break;
        }

    }
}

