package com.payment.phonepe;

public class PaymentOption {
    private String optionName;
    private int imageResId; // Resource ID for the vector image

    public PaymentOption(String optionName, int imageResId) {
        this.optionName = optionName;
        this.imageResId = imageResId;
    }

    public String getOptionName() {
        return optionName;
    }

    public int getImageResId() {
        return imageResId;
    }
}
