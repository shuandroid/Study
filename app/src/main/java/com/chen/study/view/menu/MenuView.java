package com.chen.study.view.menu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.chen.study.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by chen
 * Date : 15-11-20
 * Name : Study
 */
public class MenuView extends LinearLayout {


    @Bind(R.id.list_catalog)
    RecyclerView catalogView;

    @Bind(R.id.list_goods)
    RecyclerView goodsView;

    private Context mContext;

    public MenuView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        View view = ((LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                .inflate(R.layout.widget_menu, this, true);
        ButterKnife.bind(view, this);
    }

    //TODO: 对需要的的两个RecyclerView 进行处理.

}
