package com.example.signup;

import static com.example.signup.MainNavigationDrawer.arr_cart;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class CartFragment extends Fragment {

    public static CartFragment newInstance() {
        CartFragment fragment = new CartFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    ListView lv;
    TextView noItems;
    Button placeOrder;
    static CustomListAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_cart, container, false);

        lv= rootView.findViewById(R.id.listview);
        noItems = rootView.findViewById(R.id.noItems);
        placeOrder = rootView.findViewById(R.id.placeOrder);

        // Check if the cart is empty and set the visibility of the TextView accordingly
        if (arr_cart.isEmpty()) {
            noItems.setVisibility(View.VISIBLE);
        } else {
            noItems.setVisibility(View.GONE);
            placeOrder.setVisibility(View.VISIBLE);
            adapter = new CustomListAdapter(arr_cart,getContext(),"Cart");
            lv.setAdapter(adapter);
        }
        placeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Your order successfully placed",Toast.LENGTH_LONG).show();
                arr_cart.removeAll(arr_cart);
                loadFragment(new CartFragment(),1);
            }
        });
        return rootView;
    }
    private void loadFragment(Fragment fragment, int flag) {
        FragmentManager fm = getParentFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (flag == 0)
        {
            ft.add(R.id.container, fragment);
        }
        else
        {
            ft.replace(R.id.container, fragment);
        }

        ft.commit();
    }

}