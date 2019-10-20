package com.example.demo.fragmenttest;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.demo.fragmenttest.data.New;
import com.example.demo.fragmenttest.data.NewsAdapter;
import com.example.demo.fragmenttest.data.NewsConentFragment;

import java.util.ArrayList;
import java.util.List;

public class NewsTitleFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ListView newstitleListView;
    private List<New> newList;
    private NewsAdapter adapter;
    private boolean isTwoPane;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        newList = getNews();// init news data
        adapter = new NewsAdapter(getActivity(),R.layout.news_item,newList);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_title_frag,container,false);
        newstitleListView = (ListView)view.findViewById(R.id.news_title_list_view);
        newstitleListView.setAdapter(adapter);
        newstitleListView.setOnItemClickListener(this);
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        if (getActivity().findViewById(R.id.news_content_layout) != null){
            isTwoPane = true;
        }else {
            isTwoPane = false;
        }
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        New news = newList.get(position);
        if (isTwoPane){
            NewsConentFragment newsConentFragment = (NewsConentFragment)getFragmentManager().findFragmentById(R.id.news_content_fragment);
            newsConentFragment.refresh(news.getTitle(),news.getContent());
        }else {
            NewsContentActivity.actionStart(getActivity(),news.getTitle(),news.getContent());
        }
    }


    private List<New> getNews(){
        List<New> newList = new ArrayList<New>();
        New news1 = new New();
        news1.setTitle("one new");
        news1.setContent("one new data");
        newList.add(news1);
        New news2 = new New();
        news2.setTitle("two new");
        news2.setContent("two new data");
        newList.add(news2);
        return newList;
    }
}
