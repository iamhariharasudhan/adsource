package com.payment.phonepe;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home_Fragment extends Fragment {

    private RecyclerView recyclerViewProducts;
    private ProductAdapter productAdapter;
    private List<Product> productList;

    private static final String TAG = "HomeFragment";  // For logging

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home_, container, false);

        // Find RecyclerView and set layout manager
        recyclerViewProducts = rootView.findViewById(R.id.recyclerViewPaymentOptions);
        recyclerViewProducts.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewProducts.setHasFixedSize(true);

        // Fetch data from API
        fetchProducts();

        return rootView;
    }

    private void fetchProducts() {
        ApiService apiService = RetrofitClient.getApiService();

        // Make the API call
        Call<List<Product>> call = apiService.getProducts();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if (response.isSuccessful()) {
                    productList = response.body();

                    // Log the size of the received list
                    Log.d(TAG, "Products received, count: " + productList.size());

                    // Set up adapter with the product list
                    productAdapter = new ProductAdapter(getContext(), productList);
                    recyclerViewProducts.setAdapter(productAdapter);
                } else {
                    Log.e(TAG, "Response failed: " + response.message());
                    Toast.makeText(getContext(), "Failed to load products", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Log.e(TAG, "API call failed: " + t.getMessage());
                Toast.makeText(getContext(), "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}



//package com.payment.phonepe;
//
//
//import static com.payment.phonepe.R.id.recyclerViewPaymentOptions;
//
//import android.annotation.SuppressLint;
//import android.os.Bundle;
//import androidx.fragment.app.Fragment;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Toast;
//
//import java.util.ArrayList;
//import java.util.List;
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class Home_Fragment extends Fragment {
//
//    private RecyclerView recyclerViewPaymentOptions;
//    private PaymentOptionAdapter paymentOptionAdapter;
//    private List<PaymentOption> paymentOptionList;
//    public Home_Fragment() {
//        // Required empty public constructor
//    }
//
//    public static Home_Fragment newInstance(String param1, String param2) {
//        Home_Fragment fragment = new Home_Fragment();
//        Bundle args = new Bundle();
//        args.putString("param1", param1);
//        args.putString("param2", param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            String mParam1 = getArguments().getString("param1");
//            String mParam2 = getArguments().getString("param2");
//        }
//    }
//
//    @SuppressLint("MissingInflatedId")
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View rootView = inflater.inflate(R.layout.fragment_home_, container, false);
//
//        // Find RecyclerView and set layout manager
//        recyclerViewPaymentOptions = rootView.findViewById(R.id.recyclerViewPaymentOptions);
//        recyclerViewPaymentOptions.setLayoutManager(new LinearLayoutManager(getContext()));
//        recyclerViewPaymentOptions.setHasFixedSize(true);
//        recyclerViewPaymentOptions.setNestedScrollingEnabled(false);
//
//        // Create a list of payment options
//        paymentOptionList = new ArrayList<>();
//        paymentOptionList.add(new PaymentOption("Mobile Recharge", R.drawable.mobile));
//        paymentOptionList.add(new PaymentOption("DTH Recharge", R.drawable.mobileapp));
//        paymentOptionList.add(new PaymentOption("Insurance Payment", R.drawable.lifeinsurance));
//        paymentOptionList.add(new PaymentOption("Landline Payment", R.drawable.telephone));
//        paymentOptionList.add(new PaymentOption("Send Money", R.drawable.transfer));
//        paymentOptionList.add(new PaymentOption("Bank Transfer", R.drawable.wiretransfer));
//        paymentOptionList.add(new PaymentOption("Credit Card Payment", R.drawable.baseline_credit_card_24));
//        paymentOptionList.add(new PaymentOption("Loan", R.drawable.loan));
//        paymentOptionList.add(new PaymentOption("FASTag Recharge", R.drawable.toll));
//        paymentOptionList.add(new PaymentOption("Investment", R.drawable.loan));
//        paymentOptionList.add(new PaymentOption("Receive Money", R.drawable.transfer));
//
//        // Set up adapter with click listener
//        paymentOptionAdapter = new PaymentOptionAdapter(getContext(), paymentOptionList, paymentOption -> {
//            // Handle click event - here you can show the details of the clicked item
//            showPaymentOptionDetails(paymentOption);
//        });
//
//        recyclerViewPaymentOptions.setAdapter(paymentOptionAdapter);
//
//        return rootView;
//    }
//    private void showPaymentOptionDetails(PaymentOption paymentOption) {
//        // Display clicked option's name and image
//        String clickedOptionName = paymentOption.getOptionName();
//        String clickedOptionImage = paymentOption.getImageUrl();
//
//        // For example, show a Toast or start a new fragment/activity
//        Toast.makeText(getContext(), "Clicked: " + clickedOptionName, Toast.LENGTH_SHORT).show();
//    }
//}
