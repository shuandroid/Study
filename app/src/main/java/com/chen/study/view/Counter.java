package com.chen.study.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chen.study.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by chen
 * Date : 15-11-20
 * Name : Study
 */
public class Counter extends LinearLayout {

    private int amount = 1;
    private OnNumberChangedListener onNumberChangedListener;

    @Bind(R.id.subtract)
    ImageView subtractImage;

    @OnClick(R.id.subtract)
    void subtract () {

    }

    @Bind(R.id.number)
    TextView number;

    @OnClick(R.id.plus)
    void plus () {
        amount++;
        if (null != onNumberChangedListener) {
            onNumberChangedListener.onNumberChanged(amount);
        }
        setNumber(amount);
    }

    public Counter(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = ((LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.widget_counter_layout, this,
                true);
        ButterKnife.bind(this, view);
        init();
    }

    private void init() {
        number.setText(String.valueOf(0));
        setNumber(0);
    }

    public void setNumber(int amount) {
        this.amount = amount;
        number.setText(amount+"");
        if (0 == amount) {
            subtractImage.setVisibility(INVISIBLE);
        } else {
            subtractImage.setVisibility(VISIBLE);
        }

    }

    public interface OnNumberChangedListener {
        void onNumberChanged(int amount);
    }
}
