package com.example.signup;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    ListView lv;
    CustomListAdapter adapter;
    public ArrayList<home_list_pojo> arr_bean;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        lv= rootView.findViewById(R.id.listview);
        arr_bean= new ArrayList<>();

        arr_bean.add(new home_list_pojo(R.drawable.p1));
        arr_bean.add(new home_list_pojo(R.drawable.p2));
        arr_bean.add(new home_list_pojo(R.drawable.p3));
        arr_bean.add(new home_list_pojo(R.drawable.p4));
        arr_bean.add(new home_list_pojo(R.drawable.p5));
        arr_bean.add(new home_list_pojo(R.drawable.p6));
        arr_bean.add(new home_list_pojo(R.drawable.p7));
        arr_bean.add(new home_list_pojo(R.drawable.p8));
        arr_bean.add(new home_list_pojo(R.drawable.p9));
        arr_bean.add(new home_list_pojo(R.drawable.p10));
        arr_bean.add(new home_list_pojo(R.drawable.p11));
        arr_bean.add(new home_list_pojo(R.drawable.p12));
        arr_bean.add(new home_list_pojo(R.drawable.p13));
        arr_bean.add(new home_list_pojo(R.drawable.p14));
        arr_bean.add(new home_list_pojo(R.drawable.p15));
        arr_bean.add(new home_list_pojo(R.drawable.p16));
        arr_bean.add(new home_list_pojo(R.drawable.p17));
        arr_bean.add(new home_list_pojo(R.drawable.p18));
        arr_bean.add(new home_list_pojo(R.drawable.p19));




        //String flag = "home";
        adapter=new CustomListAdapter(arr_bean,getContext(),"Home");
        lv.setAdapter(adapter);
        return rootView;
    }
}