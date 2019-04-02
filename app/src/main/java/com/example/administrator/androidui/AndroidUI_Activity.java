package com.example.administrator.androidui;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class AndroidUI_Activity extends AppCompatActivity
{
    int[] imageIds=new int[]
            {
                    R.drawable.p1,
                    R.drawable.p2,
                    R.drawable.p3
            };
    //确定图片库所含文件
    private AdapterViewFlipper flipper;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.android_ui_layout);
        flipper=(AdapterViewFlipper) findViewById(R.id.flipper);
        //获取flipper
        BaseAdapter adapter=new BaseAdapter()
        {
            @Override
            public int getCount()
            {
                return imageIds.length;
            }
            //得到图片库大小数据
            @Override
            public Object getItem(int position)
            {
                return position;
            }
            @Override
            public long getItemId(int position)
            {
                return position;
            }
            @Override
            public View getView(int position, View convertView, ViewGroup parent)
            {
                ImageView imageView=new ImageView(AndroidUI_Activity.this);
                imageView.setImageResource(imageIds[position]);
                //创建一个ImageView，并指定图片来源
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                ));
                //设置ImageView的缩放方式和布局参数
                return imageView;
            }
            //返回的imageView代表了每个列表项
        };
        //创建一个BaseAdapter，负责提供所显示的列表项
        flipper.setAdapter(adapter);
    }
    public void prev(View source)
    {
        flipper.showPrevious();
        flipper.stopFlipping();
    }
    //上一张这个按钮的功能
    public void next(View source)
    {
        flipper.showNext();
        flipper.stopFlipping();
    }
    //下一张这个按钮的功能
    public void auto(View source)
    {
        flipper.startFlipping();
    }
    //自动播这个按钮的功能

}
