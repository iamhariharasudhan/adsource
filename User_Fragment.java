package com.payment.phonepe;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class User_Fragment extends Fragment {

    private TextView textViewUserInfo;
    private static final String PREF_NAME = "UserInfo";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_, container, false);

        textViewUserInfo = view.findViewById(R.id.textViewUserInfo);

        // Load and display saved data from SharedPreferences
          loadDataFromSharedPreferences();

        return view;
    }

    // Method to load data from SharedPreferences
    private void loadDataFromSharedPreferences() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        String name = sharedPreferences.getString("name", "No Name");
        String email = sharedPreferences.getString("email", "No Email");
        String gender = sharedPreferences.getString("gender", "No Gender");
        String occupation = sharedPreferences.getString("occupation", "No Occupation");
        String phone = sharedPreferences.getString("phone", "No Phone");

        // Display the data in the TextView
        String displayText = "Name: " + name + "\n" +
                "Email: " + email + "\n" +
                "Gender: " + gender + "\n" +
                "Occupation: " + occupation + "\n" +
                "Phone: " + phone;

        textViewUserInfo.setText(displayText);
    }
}
