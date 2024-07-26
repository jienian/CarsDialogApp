package com.nim.carsdialogapp;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button mBt;
    private LinearLayout driveMode;
    private LinearLayout reverseMode;
    private TextView driveText;
    private TextView reverseText;
    private ImageView driveLine;
    private ImageView reverseLine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mBt = findViewById(R.id.main_bt);
        mBt.setOnClickListener(v -> showMirrorAdjustDialog());

        driveMode = findViewById(R.id.drive_mode);
        reverseMode = findViewById(R.id.reverse_mode);
        driveText = findViewById(R.id.drive_text);
        reverseText = findViewById(R.id.reverse_text);
        driveLine = findViewById(R.id.drive_line);
        reverseLine = findViewById(R.id.reverse_line);

        driveMode.setSelected(true); // 默认选中行车模式
        reverseMode.setSelected(false);

        driveMode.setOnClickListener(v -> {
            selectDriveMode();
        });

        reverseMode.setOnClickListener(v -> {
            selectReverseMode();
        });
    }

    private void selectDriveMode() {
        driveMode.setSelected(true);
        reverseMode.setSelected(false);
        driveText.setTextColor(getResources().getColor(android.R.color.black));
        reverseText.setTextColor(getResources().getColor(android.R.color.darker_gray));
        driveLine.setVisibility(View.VISIBLE);
        reverseLine.setVisibility(View.INVISIBLE);
    }

    private void selectReverseMode() {
        driveMode.setSelected(false);
        reverseMode.setSelected(true);
        driveText.setTextColor(getResources().getColor(android.R.color.darker_gray));
        reverseText.setTextColor(getResources().getColor(android.R.color.black));
        driveLine.setVisibility(View.INVISIBLE);
        reverseLine.setVisibility(View.VISIBLE);
    }

    private void showMirrorAdjustDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_layout);

        // 设置Dialog的尺寸和位置
        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        params.copyFrom(dialog.getWindow().getAttributes());
        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialog.getWindow().setAttributes(params);

        // 允许点击Dialog外部区域关闭Dialog
        dialog.setCanceledOnTouchOutside(true);

        // 设置Dialog背景透明
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        dialog.show();
    }
}