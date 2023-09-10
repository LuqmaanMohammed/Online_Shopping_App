package com.example.signup;


import static com.example.signup.Login.userEmail;
import static com.example.signup.Login.userName;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.signup.ui.DatabaseHelper;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;


public class MainNavigationDrawer extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    public static ArrayList<home_list_pojo> arr_cart;
    DatabaseHelper databaseHelper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_navigation_drawer);

        arr_cart = new ArrayList<>();

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        toolbar = findViewById(R.id.toolbar);


        View navigationDrawerHeader = navigationView.getHeaderView(0);

        TextView gmailTextView = navigationDrawerHeader.findViewById(R.id.header_sub_title);
        gmailTextView.setText(userEmail);


        TextView usernameTextView = navigationDrawerHeader.findViewById(R.id.header_title);
        userName = databaseHelper.getUserName(userEmail);
        usernameTextView.setText(userName);


        loadFragment(new HomeFragment(),0);


        //step1

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);

        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(item -> {

            int id = item.getItemId();

            if(id == R.id.nav_home)
                {
                    toolbar.setTitle("Home");
                    loadFragment(new HomeFragment(),1);
                }
            else if(id == R.id.nav_account_info)
            {
                toolbar.setTitle("Account Information");
                loadFragment(new AboutFragment(),1);
            }else if(id == R.id.nav_cart)
            {
                toolbar.setTitle("Cart");
                loadFragment(new CartFragment(),1);
            }else if(id == R.id.nav_sign_out)
            {

                Intent intent = new Intent(MainNavigationDrawer.this,Login.class);
                startActivity(intent);
                finish();
            }

            drawerLayout.closeDrawer(GravityCompat.START);


            return true;
        });
    }


    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {
        super.onBackPressed();
        }
    }

    private void loadFragment(Fragment fragment, int flag) {
        FragmentManager fm = getSupportFragmentManager();
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