package com.payment.phonepe;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Homepage extends AppCompatActivity {
    private RecyclerView recyclerViewPaymentOptions;
    private PaymentOptionAdapter paymentOptionAdapter;
    private List<PaymentOption> paymentOptionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        // recycle view for it
        /*recyclerViewPaymentOptions = findViewById(R.id.recyclerViewPaymentOptions);
        recyclerViewPaymentOptions.setLayoutManager(new LinearLayoutManager(this));
        // Create the payment option list with icons

        paymentOptionList = new ArrayList<>();
        paymentOptionList.add(new PaymentOption("Mobile Recharge", R.drawable.mobile));
        paymentOptionList.add(new PaymentOption("DTH Recharge", R.drawable.mobileapp));
        paymentOptionList.add(new PaymentOption("Insurance Payment", R.drawable.lifeinsurance));
        paymentOptionList.add(new PaymentOption("Landline Payment", R.drawable.telephone));
        paymentOptionList.add(new PaymentOption("Send Money",R.drawable.transfer));
        paymentOptionList.add(new PaymentOption("Bank Transfer",R.drawable.wiretransfer));
        paymentOptionList.add(new PaymentOption("Credit Card Payment",R.drawable.baseline_credit_card_24));
        paymentOptionList.add(new PaymentOption("Loan",R.drawable.loan));
        paymentOptionList.add(new PaymentOption("FASTag Recharge",R.drawable.toll));

        // Set up the adapter
        paymentOptionAdapter = new PaymentOptionAdapter(this, paymentOptionList);
        recyclerViewPaymentOptions.setAdapter(paymentOptionAdapter);
*/        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Set default fragment when activity is first created
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new Home_Fragment()).commit();
        }

        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            // Handle navigation item clicks
            if (item.getItemId() == R.id.nav_home){
                selectedFragment = new Home_Fragment();
            } else if (item.getItemId() == R.id.nav_search) {
                selectedFragment = new Search_Fragment();
            } else if (item.getItemId() == R.id.nav_payments) {
                selectedFragment = new Payment_Fragment();
            } else if (item.getItemId() == R.id.nav_user) {
                selectedFragment = new User_Fragment();
            }

            // Replace fragment only if it's not null
            if (selectedFragment != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame_container, selectedFragment)
                        .commit();
            }
            return true;
        });
    }
}
