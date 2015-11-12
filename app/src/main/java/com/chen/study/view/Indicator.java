package com.chen.study.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;

import com.chen.study.R;

/**
 * Created by chen
 * Date : 15-11-13
 * Name : Study
 */
public class Indicator extends View {

    private Paint circlePaint;

    private Paint fillPaint;

    private int circleColor;

    private int fillColor;

    private float strokeWidth;

    private float childWidth;

    private float height;

    private float offset = 0;

    private int number;


    private static int VIEW_PAGER_NUMBER = 4;

    public Indicator(Context context) {
        super(context);
    }

    public Indicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.Indicator);
        circleColor = array.getColor(R.styleable.Indicator_circle_color, Color.WHITE);
        fillColor = array.getColor(R.styleable.Indicator_fill_color, Color.WHITE);
        strokeWidth = array.getDimension(R.styleable.Indicator_stroke_width, 3);
        array.recycle();
        initPaint();
    }

    private void initPaint() {
        circlePaint = new Paint();
        circlePaint.setColor(circleColor);
        circlePaint.setAntiAlias(true);
        circlePaint.setStyle(Paint.Style.STROKE);
        circlePaint.setStrokeWidth(strokeWidth);

        fillPaint = new Paint();
        fillPaint.setAntiAlias(true);
        fillPaint.setColor(fillColor);

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        height = MeasureSpec.getSize(heightMeasureSpec);
        childWidth = MeasureSpec.getSize(widthMeasureSpec) / VIEW_PAGER_NUMBER;
        childWidth = childWidth > height ? height : childWidth;
    }


    public void setViewPager(ViewPager viewPager) {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                offset = positionOffset;
                number = position;
                invalidate();
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawCircle(canvas, circlePaint);
        canvas.drawCircle(number * childWidth + childWidth / 2 + offset * childWidth, height / 2,
                childWidth / VIEW_PAGER_NUMBER, fillPaint);
    }


    public void drawCircle(Canvas canvas, Paint paint) {
        for (int i = 0; i < VIEW_PAGER_NUMBER; i++) {
            float centerX = i * childWidth + childWidth / 2;
            float centerY = height / 2;
            canvas.drawCircle(centerX, centerY, childWidth / VIEW_PAGER_NUMBER, paint);
        }
    }
}
