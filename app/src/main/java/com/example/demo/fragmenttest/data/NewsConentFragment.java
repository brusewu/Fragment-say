package com.example.demo.fragmenttest.data;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.demo.fragmenttest.R;

public class NewsConentFragment extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.news_frag,container,false);

        return view;
    }

    public void refresh(String newsTitle,String newsContext){
        View visibilityLayout = view.findViewById(R.id.news_layout);
        visibilityLayout.setVisibility(View.VISIBLE);
        TextView newsTitleText = (TextView) view.findViewById(R.id.news_title);
        TextView newsContextText = (TextView) view.findViewById(R.id.news_data);
        newsTitleText.setText(newsTitle);
        newsContextText.setText(newsContext);
    }
}
