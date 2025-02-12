package com.payment.phonepe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class userinfo extends AppCompatActivity {
    private EditText editText1,editText2,editText3;
    private RadioGroup radiogroup1;
    private CheckBox check1,check2,check3;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userinfo);
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(userinfo.this, showuserinfo.class);
                startActivity(intent);
            }
        });


        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        radiogroup1 = findViewById(R.id.radiogroup1);
        check1 = findViewById(R.id.check1);
        check2 = findViewById(R.id.check2);
        check3 = findViewById(R.id.check3);
        editText3 = findViewById(R.id.editText3);
        button2 = findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name = editText1.getText().toString();
                String Mail = editText2.getText().toString();
                String Phone = editText3.getText().toString();

                int selectdGenderId = radiogroup1.getCheckedRadioButtonId();
                RadioButton SelectedGenderButton = findViewById(selectdGenderId);
                String Gender = SelectedGenderButton.getText().toString();

                StringBuilder Occupation = new StringBuilder();
                if (check1.isChecked()){
                    Occupation.append("Student ");
                }
                if (check2.isChecked()){
                    Occupation.append("Company ");
                }
                if (check3.isChecked()){
                    Occupation.append("Institution ");
                }

                Intent intent = new Intent(userinfo.this, showuserinfo.class);
                intent.putExtra("name", Name);
                intent.putExtra("email", Mail);
                intent.putExtra("gender", Gender);
                intent.putExtra("occupation", Occupation.toString());
                intent.putExtra("phone", Phone);

                startActivity(intent);



            }
        });


    }
}