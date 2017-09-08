package com.wangxin.spinnablestringdemo;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    private TextView  textView1, textView2, textView3, textView4, textView5, textView6;
    private int position = 0;
    private String tv01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1= (TextView) findViewById(R.id.textview1);
        textView2= (TextView) findViewById(R.id.textview2);
        textView3= (TextView) findViewById(R.id.textview3);
        textView4= (TextView) findViewById(R.id.textview4);
        textView5= (TextView) findViewById(R.id.textview5);
        textView6= (TextView) findViewById(R.id.textview6);



                tv01=textView1.getText().toString();
        String  tv02=textView2.getText().toString();
        String  tv03=textView3.getText().toString();
        String  tv04=textView4.getText().toString();
        String  tv05=textView5.getText().toString();
        String  tv06=textView6.getText().toString();

        //textview01

            handler.sendEmptyMessage(0x158);


         //textView02
        SpannableString span02=new SpannableString(tv02);
        //设置TextView的字体颜色为蓝色
        ForegroundColorSpan colorspan02=new ForegroundColorSpan(Color.parseColor("#0099FF"));
        span02.setSpan(colorspan02,3,span02.length()-1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
       //设置字体的相对大小
        RelativeSizeSpan sizespane02=new RelativeSizeSpan(1.3f);
        span02.setSpan(sizespane02,3,span02.length()-1,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //设置字体变粗
        StyleSpan stylespan02=new StyleSpan(Typeface.BOLD);
        span02.setSpan(stylespan02,3,span02.length()-1,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView2.setText(span02);

        //textView03
         SpannableString span03=new SpannableString(tv03);
        //设置字体的链接
        URLSpan  urlspan = new URLSpan("http://www.jianshu.com/u/fa19fba4ef18");
        textView3.setHighlightColor(Color.parseColor("#16646464"));
        span03.setSpan(urlspan,3,span02.length()-1,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ForegroundColorSpan colorspan03=new ForegroundColorSpan(Color.parseColor("#0099FF"));
        span03.setSpan(colorspan03,3,span02.length()-1,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView3.setText(span03);
        textView3.setMovementMethod(LinkMovementMethod.getInstance());

        SpannableString span04=new SpannableString(tv04);
        BackgroundColorSpan bgcolorspan04=new BackgroundColorSpan(Color.parseColor("#0099EE"));
        span04.setSpan(bgcolorspan04, 3, span04.length()-1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ForegroundColorSpan colorSpan04 = new ForegroundColorSpan(Color.parseColor("#FFFFFF"));
        span04.setSpan(colorSpan04, 3, span04.length()-1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ClickableSpan clickableSpan = new MyClickableSpan("123456789");
        span04.setSpan(clickableSpan, 3, span04.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView4.setText(span04);
        textView4.setMovementMethod(LinkMovementMethod.getInstance());

        //数字二次方式
        SpannableString span05=new SpannableString("22 + 32 = 13");
        SuperscriptSpan sup01=new SuperscriptSpan();
        SuperscriptSpan sup02=new SuperscriptSpan();
        span05.setSpan(sup01,1,2,Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        span05.setSpan(sup02,6,7,Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
         RelativeSizeSpan sizeSpan05=new RelativeSizeSpan(0.5f);
        RelativeSizeSpan  sizeSpan06=new RelativeSizeSpan(0.5f);
        span05.setSpan(sizeSpan05,1,2,Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        span05.setSpan(sizeSpan06,6,7,Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        textView5.setText(span05);

       //

        SpannableString span06=new SpannableString(tv06);
        //设置字体颜色
        ForegroundColorSpan colorspan06=new ForegroundColorSpan(Color.parseColor("#EE0000"));
        span06.setSpan(colorspan06,0,span06.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
       //字体放大
        RelativeSizeSpan rlsize06 = new RelativeSizeSpan(1.2f);
        span06.setSpan(rlsize06,0,span06.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //加粗
        StyleSpan styleSpan03 = new StyleSpan(Typeface.BOLD);
        span06.setSpan(styleSpan03,0,span06.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //中间横线
        StrikethroughSpan strikethroughSpan06 = new StrikethroughSpan();
        span06.setSpan(strikethroughSpan06,0,span06.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView6.setText(span06);



    }




    class MyClickableSpan extends ClickableSpan{
        private String content;

        public MyClickableSpan(String content) {
            this.content = content;
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            ds.setUnderlineText(false);
        }

        @Override
        public void onClick(View widget) {
            Intent intent = new Intent(MainActivity.this, OtherActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("content", content);
            intent.putExtra("bundle", bundle);
            startActivity(intent);
        }
    }

Handler handler=new Handler(){
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        switch (msg.what) {
            case 0x158:
                SpannableString span01 = new SpannableString(tv01);

                ForegroundColorSpan colorspan01=new ForegroundColorSpan(Color.parseColor("#0099FF"));
                span01.setSpan(colorspan01,0,span01.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                RelativeSizeSpan sizeSpan = new RelativeSizeSpan(1.2f);
                span01.setSpan(sizeSpan, position, position + 1, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                textView1.setText(span01);
                position++;
                if (position >= textView1.getText().toString().length()) {
                    position = 0;
                }
                handler.sendEmptyMessageDelayed(0x158, 150);
                break;
        }
    }
};



}
