package com.example.foodrecommend;

import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.example.foodrecommend.RouletteView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Roulette extends AppCompatActivity {

    private RouletteView rouletteView;
    private Button rotateButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roulette);

        rouletteView = findViewById(R.id.roulette_view);
        rotateButton = findViewById(R.id.rotate_button);

        Button generateButton = findViewById(R.id.generate_button);
        Button main_button1 = findViewById(R.id.main_button1);
        main_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Roulette.this, MainActivity.class);
                startActivity(intent);
            }
        });
        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showGenerateDialog();
            }
        });
        rotateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rotateRoulette();
            }
        });
    }
    private void rotateRoulette() {
        // 회전 각도를 랜덤하게 결정
        Random random = new Random();
        int randomDegrees = random.nextInt(720) + 720; // 720 ~ 1439도 범위에서 랜덤 각도

        // 룰렛을 회전시키는 애니메이션을 적용하는 코드
        ObjectAnimator rotation = ObjectAnimator.ofFloat(rouletteView, "rotation", 0f, randomDegrees);
        rotation.setDuration(2000); // 회전에 걸리는 시간 (밀리초)
        rotation.setInterpolator(new AccelerateDecelerateInterpolator()); // 가속도 보정
        rotation.start();
    }
    private void showGenerateDialog() {
        final EditText itemCountEditText = new EditText(this);
        itemCountEditText.setHint("항목 개수 입력");

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("룰렛 생성");
        builder.setView(itemCountEditText);
        builder.setPositiveButton("다음", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String itemCountStr = itemCountEditText.getText().toString();
                int itemCount = Integer.parseInt(itemCountStr);
                showItemInputDialog(itemCount);
            }
        });
        builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    private void showItemInputDialog(final int itemCount) {
        final List<String> items = new ArrayList<>();
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        for (int i = 0; i < itemCount; i++) {
            final EditText itemEditText = new EditText(this);
            itemEditText.setHint("항목 " + (i + 1) + " 입력");

            final int finalI = i;
            builder.setTitle("항목 입력")
                    .setView(itemEditText)
                    .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String itemName = itemEditText.getText().toString();
                            items.add(itemName);
                            if (items.size() == itemCount) {
                                rouletteView.setItems(items);
                            }
                        }
                    })
                    .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .show();
        }
    }
}