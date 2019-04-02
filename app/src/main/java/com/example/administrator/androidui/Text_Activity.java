package com.example.administrator.androidui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Text_Activity extends AppCompatActivity implements View.OnClickListener
{
    private EditText editText;
    //定义新变量

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_layout);
        editText=(EditText)findViewById(R.id.text_edit);
        //获得编辑文本的实例
        Button button1=(Button)findViewById(R.id.toast_bt);
        Button button2=(Button)findViewById(R.id.intent_bt);
        //获得两个按钮的实例
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        //实现对按钮点击事件的监听
    }
    //活动开启

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.toast_bt:
                String line=editText.getText().toString();
                //得到当前编辑文本的内容
                Toast.makeText(Text_Activity.this,line,Toast.LENGTH_SHORT).show();
                //实现具体内容的短提醒功能
                break;
            case R.id.intent_bt:
                Intent intent=new Intent(Text_Activity.this,AndroidUI_Activity.class);
                startActivity(intent);
                //实现显式Intent功能
        }
        //按钮响应选择
    }

}
