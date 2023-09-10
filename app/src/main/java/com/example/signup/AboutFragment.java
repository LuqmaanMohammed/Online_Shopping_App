package com.example.signup;

import static com.example.signup.Login.userEmail;
import static com.example.signup.Login.userName;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.signup.ui.DatabaseHelper;

public class AboutFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_about, container, false);

        TextView nameTextView = rootView.findViewById(R.id.about_username);
        TextView emailTextView = rootView.findViewById(R.id.about_userEmail);
        TextView  aboutTitle = rootView.findViewById(R.id.about_title);
        TextView aboutSubtitle = rootView.findViewById(R.id.about_sub_title);

        // Set user data to TextViews

        emailTextView.setText(userEmail);
        nameTextView.setText(userName);
        aboutSubtitle.setText(userEmail);
        aboutTitle.setText(userName);


        return rootView;
    }
}
