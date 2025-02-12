package com.payment.phonepe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PaymentOptionAdapter extends RecyclerView.Adapter<PaymentOptionAdapter.PaymentOptionViewHolder> {

    private Context context;
    private List<PaymentOption> paymentOptionList;

    public PaymentOptionAdapter(Context context, List<PaymentOption> paymentOptionList) {
        this.context = context;
        this.paymentOptionList = paymentOptionList;
    }

    @NonNull
    @Override
    public PaymentOptionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item_payment, parent, false);
        return new PaymentOptionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PaymentOptionViewHolder holder, int position) {
        PaymentOption paymentOption = paymentOptionList.get(position);

        holder.textViewOptionName.setText(paymentOption.getOptionName());
        holder.imageViewOption.setImageResource(paymentOption.getImageResId());
    }

    @Override
    public int getItemCount() {
        return paymentOptionList.size();
    }

    public static class PaymentOptionViewHolder extends RecyclerView.ViewHolder {

        ImageView imageViewOption;
        TextView textViewOptionName;

        public PaymentOptionViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewOption = itemView.findViewById(R.id.image_view_option);
            textViewOptionName = itemView.findViewById(R.id.text_view_option);
        }
    }
}
