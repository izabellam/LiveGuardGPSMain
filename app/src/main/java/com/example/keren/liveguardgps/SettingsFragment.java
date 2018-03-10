package com.example.keren.liveguardgps;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import VO.HomeTrackMember;
import utils.ConstantsClass;

/**
 * Created by amirlubashevsky on 09/03/2018.
 */

public class SettingsFragment extends Fragment {
    private HomeTrackMember mHomeTrackerMember;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.human_details, container, false);

        final EditText user_phone = (EditText)rootView.findViewById(R.id.user_phone);
        final EditText user_name = (EditText)rootView.findViewById(R.id.user_name);
        final EditText user_age = (EditText)rootView.findViewById(R.id.user_age);
        final EditText user_description = (EditText)rootView.findViewById(R.id.user_description);


        Button save_details = (Button)rootView.findViewById(R.id.save_details);
        save_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = user_name.getText().toString();
                String phone = user_phone.getText().toString();
                String description = user_description.getText().toString();


                mHomeTrackerMember = new HomeTrackMember(name, phone,null, description);

                enterDataToDB(mHomeTrackerMember);
                //  userDetailsClass.setPetToArr(petsClass);

                //  userDetailsClass.setPetsClasses();
            }
        });



        return rootView;
    }



    private void enterDataToDB(HomeTrackMember homeTrackMember){

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();


        DatabaseReference homeTrackersRef = FirebaseDatabase
                .getInstance()
                .getReferenceFromUrl(ConstantsClass.FIRE_BASE_URL)
                .child(uid);


        DatabaseReference pushRef = homeTrackersRef.push();
        String pushId = pushRef.getKey();
        homeTrackMember.setPushId(pushId);
        pushRef.setValue(homeTrackMember);
        //  pushRef.setValue(uid, homeTrackMember);

    }

    private void popupDialog(){
        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Delete entry")
                .setMessage("Are you sure you want to delete this entry?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }




}
