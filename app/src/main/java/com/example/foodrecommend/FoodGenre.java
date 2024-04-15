package com.example.foodrecommend;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class FoodGenre extends AppCompatActivity {

    private String[] Koreanfoods = {"비빔밥","불고기","김치찌개","된장찌개","파전"};
    private String[] Chinesefoods = {"짜장면","짬뽕","탕수육","마파두부","칠리새우","마라탕"};
    private String[] Japanesefoods = {"초밥","돈까스","우동","라멘","피자"};
    private String[] westernfoods = {"파스타","스테이크","리조또"};
    private String[] Chickenbrands = {"굽네치킨","BBQ치킨","푸라닭치킨","호식이두마리치킨","페리카나","맥시카나"};
    private String[] Pizzabrands = {"파파존스","피자마루","피자스쿨","도미노피자","59쌀피자","청년피자"};
    private String[] hamburgerbrands = {"버거킹","롯데리아","프랭크버거","KFC","맘스터치","맥도날드"};
    private String[] desserts = {"빙수","커피","빵","쿠키","아이스크림","파르페","케이크"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_genre);

        Button KoreanfoodButton = findViewById(R.id.korenfood_button);
        Button ChinesefoodButton = findViewById(R.id.chinesefood_button);
        Button JapanesefoodButton = findViewById(R.id.japanesefood_button);
        Button westernfoodButton = findViewById(R.id.westernfood_button);
        Button ChickenbrandButton = findViewById(R.id.Chickenbrand_Button);
        Button PizzabrandButton = findViewById(R.id.Pizzabrand_Button);
        Button hamburgerbrandButton = findViewById(R.id.hamburgerbrand_Button);
        Button dessertButton = findViewById(R.id.dessert_Button);
        Button main_button2 = findViewById(R.id.main_button2);
        KoreanfoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showKoreanRandomFoodDialog();
            }
        });
        ChinesefoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showChineseRandomFoodDialog();
            }
        });
        JapanesefoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showJapaneseRandomFoodDialog();
            }
        });
        westernfoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showwesternRandomFoodDialog();
            }
        });
        ChickenbrandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showChickenRandombrandDialog();
            }
        });
        hamburgerbrandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showhamburgerRandombrandDialog();
            }
        });
        PizzabrandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPizzaRandombrandDialog();
            }
        });
        dessertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showdessertRandomDialog();
            }
        });

        main_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodGenre.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void showKoreanRandomFoodDialog() {

        String KoreanFood = getKoreanRandomFood();


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("랜덤 한식 추천")
                .setMessage("추천 음식: " + KoreanFood)
                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.dismiss();
                    }
                });

        builder.create().show();
    }

    private String getKoreanRandomFood() {
        Random random = new Random();
        int index = random.nextInt(Koreanfoods.length);
        return Koreanfoods[index];
    }

    private void showChineseRandomFoodDialog() {

        String ChineseFood = getChineseRandomFood();


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("랜덤 중식 추천")
                .setMessage("추천 음식: " + ChineseFood)
                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.dismiss();
                    }
                });

        builder.create().show();
    }

    private String getChineseRandomFood() {
        Random random = new Random();
        int index = random.nextInt(Chinesefoods.length);
        return Chinesefoods[index];
    }

    private void showJapaneseRandomFoodDialog() {

        String Japanesefood = getJapaneseRandomFood();


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("랜덤 일식 추천")
                .setMessage("추천 음식: " + Japanesefood)
                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.dismiss();
                    }
                });

        builder.create().show();
    }

    private String getJapaneseRandomFood() {
        Random random = new Random();
        int index = random.nextInt(Japanesefoods.length);
        return Japanesefoods[index];
    }

    private void showwesternRandomFoodDialog() {

        String westernfood = getwesternRandomFood();


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("랜덤 양식 추천")
                .setMessage("추천 음식: " + westernfood)
                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.dismiss();
                    }
                });

        builder.create().show();
    }

    private String getwesternRandomFood() {
        Random random = new Random();
        int index = random.nextInt(westernfoods.length);
        return westernfoods[index];
    }

    private void showChickenRandombrandDialog() {

        String Chickenbrand = getChickenRandombrand();


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("랜덤 치킨브랜드 추천")
                .setMessage("추천 브랜드: " + Chickenbrand)
                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.dismiss();
                    }
                });

        builder.create().show();
    }

    private String getChickenRandombrand() {
        Random random = new Random();
        int index = random.nextInt(Chickenbrands.length);
        return Chickenbrands[index];
    }

    private void showhamburgerRandombrandDialog() {

        String hamburgerbrand = gethamburgerRandombrand();


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("랜덤 버거브랜드 추천")
                .setMessage("추천 브랜드: " + hamburgerbrand)
                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.dismiss();
                    }
                });

        builder.create().show();
    }

    private String gethamburgerRandombrand() {
        Random random = new Random();
        int index = random.nextInt(hamburgerbrands.length);
        return hamburgerbrands[index];
    }

    private void  showPizzaRandombrandDialog() {

        String Pizzabrand = getPizzaRandombrand();


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("랜덤 피자브랜드 추천")
                .setMessage("추천 브랜드: " + Pizzabrand)
                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.dismiss();
                    }
                });

        builder.create().show();
    }

    private String getPizzaRandombrand() {
        Random random = new Random();
        int index = random.nextInt(Pizzabrands.length);
        return Pizzabrands[index];
    }
    private void  showdessertRandomDialog() {

        String dessert = getdessertRandom();


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("랜덤 후식 추천")
                .setMessage("추천 후식: " + dessert)
                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.dismiss();
                    }
                });

        builder.create().show();
    }

    private String getdessertRandom() {
        Random random = new Random();
        int index = random.nextInt(desserts.length);
        return desserts[index];
    }
}