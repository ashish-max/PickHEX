package com.example.background;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SeekBar redSeekbar,greenSeekbar,blueSeekbar;

    private Button btnReset;
    private String hex;

    private LinearLayout llroot;

    private TextView red,blue,green,hexcolorcode;

    private int redcolor = 0;
    private int greencolor = 0;
    private int bluecolor = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//connects java with xml

        redSeekbar =  findViewById(R.id.seekbar_red);
        greenSeekbar =  findViewById(R.id.seekbar_green);
        blueSeekbar =  findViewById(R.id.seekbar_blue);

        red = (TextView) findViewById(R.id.red);
        blue = (TextView) findViewById(R.id.blue);
        green = (TextView) findViewById(R.id.green);
        hexcolorcode = (TextView) findViewById(R.id.hexcolorcode);


        llroot =  findViewById(R.id.ll_root);

        btnReset =  findViewById(R.id.btn_reset);

        redSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {//here i = progress,b = fromuser
                redcolor = (int)Math.round(i * 2.55);// 0 to 255/100,Rounded and typecasted
                red.setText(""+ redcolor +"");
                hex = String.format("#%02x%02x%02x",redcolor,greencolor,bluecolor);//convertion to hexcolorcode
                hexcolorcode.setText(hex);
                changebackgroundcolor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        greenSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {//here i = progress,b = fromuser
                greencolor = (int)Math.round(i * 2.55);// 0 to 255/100,Rounded and typecasted
                green.setText(""+ greencolor +"");
                hex = String.format("#%02x%02x%02x",redcolor,greencolor,bluecolor);
                hexcolorcode.setText(hex);
                changebackgroundcolor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        blueSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {//here i = progress,b = fromuser
                bluecolor = (int)Math.round(i * 2.55);// 0 to 255/100,Rounded and typecasted
                blue.setText(""+ bluecolor +"");
                hex = String.format("#%02x%02x%02x",redcolor,greencolor,bluecolor);
                hexcolorcode.setText(hex);
                changebackgroundcolor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        changebackgroundcolor();//we use this call to avoid a lag during initiating the change in seekbar

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redcolor = 0;//resetting value of colors
                greencolor = 0;
                bluecolor = 0;
                redSeekbar.setProgress(0);//restting progress values
                greenSeekbar.setProgress(0);
                blueSeekbar.setProgress(0);
            }
        });
    }

    private void changebackgroundcolor(){
        llroot.setBackgroundColor(Color.argb(255,redcolor,greencolor,bluecolor));//changes the background color of Screen
    }

}