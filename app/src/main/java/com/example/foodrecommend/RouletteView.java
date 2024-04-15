package com.example.foodrecommend;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RouletteView extends View {

    private List<String> items; // 룰렛의 항목 리스트
    private List<Integer> colors; // 항목에 대한 배경색 리스트
    private Paint paint; // 그리기를 위한 Paint 객체
    private Random random;

    public RouletteView(Context context) {
        super(context);
        init();
    }

    public RouletteView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RouletteView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(40); // 텍스트 크기를 조정합니다.
        random = new Random();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (items != null && items.size() > 0) {
            int centerX = getWidth() / 2;
            int centerY = getHeight() / 2;
            int radius = Math.min(centerX, centerY) - 50;
            int angle = 360 / items.size();

            for (int i = 0; i < items.size(); i++) {
                paint.setColor(colors.get(i));
                drawSector(canvas, centerX, centerY, radius, i * angle, angle, paint);
                drawTextOnSector(canvas, items.get(i), centerX, centerY, radius, i * angle, angle, paint);
            }
        }
    }

    private void drawSector(Canvas canvas, float cx, float cy, float radius, float startAngle, float sweepAngle, Paint paint) {
        RectF rectF = new RectF(cx - radius, cy - radius, cx + radius, cy + radius);
        canvas.drawArc(rectF, startAngle, sweepAngle, true, paint);
    }

    private void drawTextOnSector(Canvas canvas, String text, float cx, float cy, float radius, float startAngle, float sweepAngle, Paint paint) {
        float textWidth = paint.measureText(text);
        float angle = (float) Math.toRadians(startAngle + sweepAngle / 2);
        float textX = cx + (float) (radius * Math.cos(angle)) - textWidth / 2;
        float textY = cy + (float) (radius * Math.sin(angle)) + paint.getTextSize() / 2;
        paint.setColor(Color.BLACK); // 텍스트 색상을 검은색으로 설정
        canvas.drawText(text, textX, textY, paint);
    }

    public void setItems(List<String> items) {
        this.items = items;
        this.colors = generateRandomColors(items.size());
        invalidate(); // 화면 갱신 요청
    }

    private List<Integer> generateRandomColors(int size) {
        List<Integer> randomColors = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
            randomColors.add(color);
        }
        return randomColors;
    }
}
