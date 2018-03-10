package com.example.keren.liveguardgps.bluetooth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.example.keren.liveguardgps.R;

import utils.ConstantsClass;
import utils.PhoneNumberValidator;
import utils.SharedPreferencesManager;

public class PhoneToTruckScreenActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        final EditText editText = (EditText) findViewById(R.id.trackNumberText);
        Button trackButton = (Button)findViewById(R.id.trackButton);
        trackButton.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        String number = editText.getText().toString();
                        if (!PhoneNumberValidator.validatePhoneNumber(number)) {
                            editText.setError("Not a phone number");
                        } else {
                            checkIFUserExist(number);
                        }
                    }
                });



    }
    private void checkIFUserExist(String phoneNumber){

        // FireBase save all the data with email account
        //under email there will be List if pets or children

        //First screen with email and pswd/ create account, checkbox remember me
        //Create account screen with all pets/child data, popup for entering more pets/chilren

       /* FirebaseStorage storage = FirebaseStorage.getInstance(ConstantsClass.FIRE_BASE_URL);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");*/

        SharedPreferencesManager prefrenceManager = SharedPreferencesManager.getInstance(getApplicationContext());
        String user_phone = prefrenceManager.getStringSharedPreferences(ConstantsClass.USER_PHONE,"");
        if(phoneNumber == null){
         //   prefrenceManager.putStringSharedPreferences(ConstantsClass.USER_PHONE,user_phone);
//            Intent i = new Intent(PhoneToTruckScreenActivity.this, PetsDetailsScreen.class);
//            startActivity(i);
        }else{
            prefrenceManager.putStringSharedPreferences(ConstantsClass.USER_PHONE,user_phone);
            //go to another screen
        }
    }
}
