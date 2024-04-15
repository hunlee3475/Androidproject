package com.example.foodrecommend;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;


import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private String[] foods = {"피자", "파스타", "햄버거", "샐러드", "스테이크", "초밥", "짜장면",
            "짬뽕", "탕수육", "김밥", "돈까스", "회덮밥", "오므라이스", "치킨", "닭갈비",
            "보쌈", "삼겹살", "불고기", "갈비찜", "족발", "쌀국수", "타코", "브리또",
            "떡볶이", "순대", "쫄면", "냉면", "비빔밥", "라면", "만두", "매운탕",
            "샤브샤브", "순두부찌개", "해물탕", "곱창", "삼계탕", "감자탕", "쭈꾸미",
            "마라탕", "어묵", "닭꼬치", "떡꼬치", "샌드위치", "햄버거스테이크", "국밥",
            "카레","우동","생선구이","덮밥","마파두부","파전"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.roulette_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String randomFood = getRandomFood();
                Intent intent = new Intent(MainActivity.this, Roulette.class);
                startActivity(intent);

            }
        });

        Button randomFoodButton = findViewById(R.id.randomfood_button);
        randomFoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRandomFoodDialog();
            }
        });


        Button Genrebutton = findViewById(R.id.Genre_button);
        Genrebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FoodGenre.class);
                startActivity(intent);

            }
        });
    }

    private void showRandomFoodDialog() {
        // 랜덤 음식 추천
        String randomFood = getRandomFood();

        // 다이얼로그 생성
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("랜덤 음식 추천")
                .setMessage("추천 음식: " + randomFood)
                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // 확인    버튼을 누르면 다이얼로그 닫기
                        dialog.dismiss();
                    }
                });
        // 다이얼로그 표시
        builder.create().show();
    }

    private String getRandomFood() {
        Random random = new Random();
        int index = random.nextInt(foods.length);
        return foods[index];
    }
}


