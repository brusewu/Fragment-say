package com.example.demo.fragmenttest.data;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.demo.fragmenttest.R;

import java.util.List;

public class NewsAdapter extends ArrayAdapter<New> {
    private int resourceId;

    public NewsAdapter(Context context, int textViewResourId, List<New> objects) {
        super(context, textViewResourId,objects);
        resourceId = textViewResourId;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        New news = getItem(position);
        View view;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,null);

        }else {
            view = convertView;
        }
        TextView newsTitleText = (TextView) view.findViewById(R.id.news_title);
        newsTitleText.setText(news.getTitle());
        return view;
    }
}
