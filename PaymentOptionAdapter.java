package com.payment.phonepe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private Context context;
    private List<Product> productList;

    public ProductAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item_payment, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);

        // Bind data to the views
        holder.productTitle.setText(product.getTitle());
        holder.productDescription.setText(product.getDescription());
        holder.productPrice.setText("₹" + product.getPrice());

        // Load the product image using Glide (or any other image loading library)
        Glide.with(context)
                .load(product.getImage())
                .into(holder.productImage);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {

        ImageView productImage;
        TextView productTitle, productDescription, productPrice;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            productImage = itemView.findViewById(R.id.productImage);
            productTitle = itemView.findViewById(R.id.productTitle);
            productDescription = itemView.findViewById(R.id.productDescription);
            productPrice = itemView.findViewById(R.id.productPrice);
        }
    }
}



//import android.content.Context;
//import android.content.Intent;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.bumptech.glide.Glide;
//
//import java.util.List;
//public class PaymentOptionAdapter extends RecyclerView.Adapter<PaymentOptionAdapter.PaymentOptionViewHolder> {
//
//    private Context context;
//    private List<PaymentOption> paymentOptionList;
//    private OnItemClickListener onItemClickListener;
//
//    // Constructor
//    public PaymentOptionAdapter(Context context, List<PaymentOption> paymentOptionList, OnItemClickListener onItemClickListener) {
//        this.context = context;
//        this.paymentOptionList = paymentOptionList;
//        this.onItemClickListener = onItemClickListener;
//    }
//
//    // Define ViewHolder
//    public static class PaymentOptionViewHolder extends RecyclerView.ViewHolder {
//        ImageView paymentOptionImage;
//        TextView paymentOptionName;
//
//        public PaymentOptionViewHolder(@NonNull View itemView) {
//            super(itemView);
//            paymentOptionImage = itemView.findViewById(R.id.image_view_option);
//            paymentOptionName = itemView.findViewById(R.id.text_view_option);
//        }
//    }
//
//    @NonNull
//    @Override
//    public PaymentOptionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item_payment, parent, false);
//        return new PaymentOptionViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull PaymentOptionViewHolder holder, int position) {
//        PaymentOption option = paymentOptionList.get(position);
//
//        // Load the image using Glide (Ensure you have added Glide dependency in build.gradle)
//        Glide.with(context).load(option.getImageUrl()).into(holder.paymentOptionImage);
//
//        // Set the name
//        holder.paymentOptionName.setText(option.getOptionName());
//
//        holder.itemView.setOnClickListener(v -> onItemClickListener.onItemClick(option));
//    }
//
//    @Override
//    public int getItemCount() {
//        return paymentOptionList.size();
//    }
//
//    public interface OnItemClickListener {
//        void onItemClick(PaymentOption option);
//    }
//}

    // Define the OnItemClickListener interface
//    public interface OnItemClickListener {
//        void onItemClick(PaymentOption paymentOption);  // Triggered when an item is clicked
//    }
//
//    // Constructor for adapter with OnItemClickListener
//    public PaymentOptionAdapter(Context context, List<PaymentOption> paymentOptionList, OnItemClickListener onItemClickListener) {
//        this.context = context;
//        this.paymentOptionList = paymentOptionList;
//        this.onItemClickListener = onItemClickListener;
//    }
//
//    @NonNull
//    @Override
//    public PaymentOptionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item_payment, parent, false);
//        return new PaymentOptionViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull PaymentOptionViewHolder holder, int position) {
//        PaymentOption paymentOption = paymentOptionList.get(position);
//
//        holder.textViewOptionName.setText(paymentOption.getOptionName());
//        holder.imageViewOption.setImageResource(paymentOption.getImageResId());
//
//        // Set OnClickListener to handle item clicks
//        holder.itemView.setOnClickListener(v -> {
//            // Create an intent to open PaymentDetailActivity
//            Intent intent = new Intent(context, PaymentDetailActivity.class);
//            // Pass the clicked option's name and image resource ID to the new activity
//            intent.putExtra("optionName", paymentOption.getOptionName());
//            intent.putExtra("imageResId", paymentOption.getImageResId());
//
//            // Start the activity with the passed data
//            context.startActivity(intent);
//        });
//    }
//
//    @Override
//    public int getItemCount() {
//        return paymentOptionList.size();
//    }
//
//    // ViewHolder class for holding references to views
//    public static class PaymentOptionViewHolder extends RecyclerView.ViewHolder {
//
//        ImageView imageViewOption;
//        TextView textViewOptionName;
//
//        public PaymentOptionViewHolder(@NonNull View itemView) {
//            super(itemView);
//            imageViewOption = itemView.findViewById(R.id.image_view_option);
//            textViewOptionName = itemView.findViewById(R.id.text_view_option);
//        }
//    }
//}





























// package com.payment.phonepe;

// import android.content.Context;
// import android.view.LayoutInflater;
// import android.view.View;
// import android.view.ViewGroup;
// import android.widget.ImageView;
// import android.widget.TextView;

// import androidx.annotation.NonNull;
// import androidx.recyclerview.widget.RecyclerView;

// import java.util.List;

// public class PaymentOptionAdapter extends RecyclerView.Adapter<PaymentOptionAdapter.PaymentOptionViewHolder> {

//     private Context context;
//     private List<PaymentOption> paymentOptionList;

//     public PaymentOptionAdapter(Context context, List<PaymentOption> paymentOptionList) {
//         this.context = context;
//         this.paymentOptionList = paymentOptionList;
//     }

//     @NonNull
//     @Override
//     public PaymentOptionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//         View view = LayoutInflater.from(context).inflate(R.layout.recycler_item_payment, parent, false);
//         return new PaymentOptionViewHolder(view);
//     }

//     @Override
//     public void onBindViewHolder(@NonNull PaymentOptionViewHolder holder, int position) {
//         PaymentOption paymentOption = paymentOptionList.get(position);

//         holder.textViewOptionName.setText(paymentOption.getOptionName());
//         holder.imageViewOption.setImageResource(paymentOption.getImageResId());
//     }

//     @Override
//     public int getItemCount() {
//         return paymentOptionList.size();
//     }

//     public static class PaymentOptionViewHolder extends RecyclerView.ViewHolder {

//         ImageView imageViewOption;
//         TextView textViewOptionName;

//         public PaymentOptionViewHolder(@NonNull View itemView) {
//             super(itemView);
//             imageViewOption = itemView.findViewById(R.id.image_view_option);
//             textViewOptionName = itemView.findViewById(R.id.text_view_option);
//         }
//     }
// }
