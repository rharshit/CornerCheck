package com.example.cornercheck;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {

    SeekBar sbTop;

    TextView tvTop;

    CardView cv;

    double radius;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.activity_main);

        cv = findViewById(R.id.cardView);
        sbTop = findViewById(R.id.sb_corner);
        tvTop = findViewById(R.id.tvTop);

        sbTop.setProgress(100);
        radius = sbTop.getProgress();
        cv.setRadius((int) radius);
        tvTop.setText(String.format("Radius: %dpx", (int) radius));

        sbTop.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                radius = i;
                cv.setRadius((int) radius);
                tvTop.setText(String.format("Radius: %dpx", (int) radius));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
