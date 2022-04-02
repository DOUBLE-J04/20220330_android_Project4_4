package com.example.android_project4_4;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView text1,text2;
    Switch ChkAgree;
    RadioGroup group1;
    RadioButton eleven , nuga, pie;
    ImageView imgPet;
    Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayShowHomeEnabled(true);
        ab.setDisplayUseLogoEnabled(true);
        ab.setIcon(R.drawable.my);
        setTitle(" 안드로이드 사진보기");

        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);

        ChkAgree = (Switch) findViewById(R.id.ChkAgree);
        group1 = (RadioGroup) findViewById(R.id.group1);
        nuga = (RadioButton) findViewById(R.id.nuga);
        pie = (RadioButton) findViewById(R.id.pie);
        eleven = (RadioButton) findViewById(R.id.eleven);

        imgPet = (ImageView) findViewById(R.id.ImgPet);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);

    }

    public void onCheckboxClicked(View view){
        boolean checked = ((Switch) view).isChecked();

        if(checked){
            text2.setVisibility(View.VISIBLE);
            group1.setVisibility(View.VISIBLE);
            imgPet.setVisibility(View.VISIBLE);
        }
        else{
            text2.setVisibility(View.INVISIBLE);
            group1.setVisibility(View.INVISIBLE);
            imgPet.setVisibility(View.INVISIBLE);
        }
    }
    public void onClick(View view){
        switch (group1.getCheckedRadioButtonId()){
            case R.id.nuga:
                imgPet.setImageResource(R.drawable.nuga);
                break;
            case R.id.pie:
                imgPet.setImageResource(R.drawable.pie);
                break;
            case R.id.eleven:
                imgPet.setImageResource(R.drawable.eleven);
                break;
        }
        switch (view.getId()) {
            case R.id.button1:
                moveTaskToBack(true);// task를 백그라운드로 이동
                finishAndRemoveTask();	// 액티비티 종료 + tasklist에서 지우기
                android.os.Process.killProcess(android.os.Process.myPid()); //프로세스종료
                break;
            case R.id.button2:
                text2.setVisibility(View.INVISIBLE);
                group1.setVisibility(View.INVISIBLE);
                imgPet.setVisibility(View.INVISIBLE);
                imgPet.setImageResource(0);

                ChkAgree.setChecked(false);
                nuga.setChecked(false);
                pie.setChecked(false);
                eleven.setChecked(false);

                break;
        }
    }
}