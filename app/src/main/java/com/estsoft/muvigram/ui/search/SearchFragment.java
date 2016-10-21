package com.estsoft.muvigram.ui.search;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.estsoft.muvigram.MuviGramApplication;
import com.estsoft.muvigram.R;
import com.estsoft.muvigram.ui.friend.FindFriendActivity;
import com.estsoft.muvigram.ui.home.HomeActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by JEONGYI on 2016. 10. 11..
 * Edited by gangGongUi on 2016. 10. 16..
 */

public class SearchFragment extends Fragment {

    @BindView(R.id.search_fragment_recyclerview) RecyclerView recyclerView;
    @BindView(R.id.action_bar) RelativeLayout mActionBar;


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        ButterKnife.bind(this, view);
        //initRecyclerView();

        final LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) mActionBar.getLayoutParams();
        params.setMargins(0, ((MuviGramApplication) getActivity().getApplication()).getStatusBarHeight(), 0, 0);
        mActionBar.setLayoutParams(params);

        return view;
    }


    private void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        SearchRecyclerAdapter adapter = new SearchRecyclerAdapter(getVideoHeader(), getBoardHeader(), getListItems());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);


    }

    private SearchHeaderVideoItem getVideoHeader() {
        final String VIDEO_FILE_NAME = "test_intro_video";
        final Uri videoFile = Uri.parse("android.resource://"+ getActivity().getPackageName() +"/raw/" + VIDEO_FILE_NAME);
        return new SearchHeaderVideoItem(videoFile, "Title");
    }

    private SearchHeaderBoardItem getBoardHeader() {
        return new SearchHeaderBoardItem("test");
    }

    public List<SearchListItem> getListItems()
    {
        List<SearchListItem> listItems = new ArrayList<>();
        for (int i = 0; i<16; i++) {
            SearchListItem item = new SearchListItem();
            if (i % 2 == 0) {
                item.setTitle("goni");
            } else {
                item.setTitle("hahaha");
            }
            listItems.add(item);
        }
        return listItems;
    }

    private void setCustomActionbar(){


        ActionBar mActionBar = ((HomeActivity) getActivity()).getDelegate().getSupportActionBar();

        View mCustomView = LayoutInflater.from(getActivity()).inflate(R.layout.actionbar_search, null);
        mActionBar.setCustomView(mCustomView);



        mCustomView.findViewById(R.id.search_bar).setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), SearchBarActivity.class));
        });

        mCustomView.findViewById(R.id.find_friend_button).setOnClickListener(v->{
           startActivity(new Intent(getActivity(), FindFriendActivity.class));
        });
    }

}