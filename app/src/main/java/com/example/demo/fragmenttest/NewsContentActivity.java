package com.example.demo.fragmenttest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


import com.example.demo.fragmenttest.data.NewsConentFragment;

public class NewsContentActivity extends AppCompatActivity {

    public static void actionStart(Context context,String newsTitle,
                                   String newsContent){
        Intent intent = new Intent(context,NewsContentActivity.class);
        intent.putExtra("news_title",newsTitle);
        intent.putExtra("news_data",newsContent);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        setContentView(R.layout.news_content);
        String newsTitle = getIntent().getStringExtra("news_title");
        String newsContent = getIntent().getStringExtra("news_data");
        NewsConentFragment newsConentFragment = (NewsConentFragment)getSupportFragmentManager().findFragmentById(R.id.news_content_fragment);
        newsConentFragment.refresh(newsTitle,newsContent);
    }
}
