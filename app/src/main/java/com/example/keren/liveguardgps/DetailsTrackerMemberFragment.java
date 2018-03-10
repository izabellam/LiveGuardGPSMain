package com.example.keren.liveguardgps;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.SupportMapFragment;

import VO.HomeTrackMember;

/**
 * Created by amirlubashevsky on 10/03/2018.
 */

public class DetailsTrackerMemberFragment extends Fragment {

    final static String DATA_RECEIVE = "data_receive";
    private HomeTrackMember mHomeTrackMember;
    private View rootView;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        System.out.println("Kate onCreateView");
        rootView = inflater.inflate(R.layout.details_tracker_members, container, false);

        if(mHomeTrackMember.getmImageUrl() ==  null) {
            ((ImageView) rootView.findViewById(R.id.details_tracker_image)).setImageDrawable(getResources().getDrawable(R.drawable.place_holder));
        }else{

            //get image from path on android device
            //  ((ImageView) rootView.findViewById(R.id.details_tracker_image)).setImageDrawable(getResources().getDrawable(R.drawable.place_holder));
        }

        ((TextView)rootView.findViewById(R.id.details_tracker_name)).setText(mHomeTrackMember.getmName());
        ((TextView)rootView.findViewById(R.id.details_tracker_description)).setText(mHomeTrackMember.getmDescription());
        ((TextView)rootView.findViewById(R.id.details_tracker_age)).setText(mHomeTrackMember.getmAge());
        ((TextView)rootView.findViewById(R.id.details_tracker_gender)).setText(mHomeTrackMember.getmGender());

        return rootView;
    }


    public void setObjectData(HomeTrackMember homeTrackMember) {
        mHomeTrackMember = homeTrackMember;

        System.out.println("Kate setObjectData");

    }
}
