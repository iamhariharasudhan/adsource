package com.payment.phonepe;


import static com.payment.phonepe.R.id.recyclerViewPaymentOptions;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class Home_Fragment extends Fragment {

    private RecyclerView recyclerViewPaymentOptions;
    private PaymentOptionAdapter paymentOptionAdapter;
    private List<PaymentOption> paymentOptionList;

    public Home_Fragment() {
        // Required empty public constructor
    }

    public static Home_Fragment newInstance(String param1, String param2) {
        Home_Fragment fragment = new Home_Fragment();
        Bundle args = new Bundle();
        args.putString("param1", param1);
        args.putString("param2", param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            String mParam1 = getArguments().getString("param1");
            String mParam2 = getArguments().getString("param2");
        }
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home_, container, false);

        // Find RecyclerView and set layout manager
        recyclerViewPaymentOptions = rootView.findViewById(R.id.recyclerViewPaymentOptions);
        recyclerViewPaymentOptions.setLayoutManager(new LinearLayoutManager(getContext()));

        // Create a list of payment options
        paymentOptionList = new ArrayList<>();
        paymentOptionList.add(new PaymentOption("Mobile Recharge", R.drawable.mobile));
        paymentOptionList.add(new PaymentOption("DTH Recharge", R.drawable.mobileapp));
        paymentOptionList.add(new PaymentOption("Insurance Payment", R.drawable.lifeinsurance));
        paymentOptionList.add(new PaymentOption("Landline Payment", R.drawable.telephone));
        paymentOptionList.add(new PaymentOption("Send Money", R.drawable.transfer));
        paymentOptionList.add(new PaymentOption("Bank Transfer", R.drawable.wiretransfer));
        paymentOptionList.add(new PaymentOption("Credit Card Payment", R.drawable.baseline_credit_card_24));
        paymentOptionList.add(new PaymentOption("Loan", R.drawable.loan));
        paymentOptionList.add(new PaymentOption("FASTag Recharge", R.drawable.toll));

        // Set up adapter and bind it to RecyclerView
        paymentOptionAdapter = new PaymentOptionAdapter(getContext(), paymentOptionList);
        recyclerViewPaymentOptions.setAdapter(paymentOptionAdapter);

        return rootView;
    }
}
