package com.example.keren.liveguardgps;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import VO.HomeTrackMember;
import utils.ConstantsClass;

/**
 * Created by amirlubashevsky on 09/03/2018.
 */

public class HomeTrackerMembersListFragment extends Fragment {

    private List<HomeTrackMember> mHomeTrackMemberList = new ArrayList<>();
    private RecyclerView trackers_list;
    private BaseTrackerAdapter mBaseTrackerAdapter;
    private HomeTrackerClicked mHomeTrackerClicked;

    public interface HomeTrackerClicked{
        void homeTrackerClicked(HomeTrackMember homeTrackMember);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.trackers_list_layout, container, false);

        getAllDetailsFromDB();

        mBaseTrackerAdapter = new BaseTrackerAdapter(mHomeTrackMemberList);
        trackers_list = rootView.findViewById(R.id.trackers_list);
        trackers_list.setHasFixedSize(true);
        trackers_list.setAdapter(mBaseTrackerAdapter);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        trackers_list.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        trackers_list.setItemAnimator(new DefaultItemAnimator());
        trackers_list.setLayoutManager(mLayoutManager);
        rowClicked();

        return rootView;
    }

    private void rowClicked(){
        mBaseTrackerAdapter.setmOnTrackerClickListener(new BaseTrackerAdapter.OnTrackerClickListener() {
            @Override
            public void onTrackerClicked(HomeTrackMember homeTrackMember) {
                mHomeTrackerClicked.homeTrackerClicked(homeTrackMember);
            }
        });
    }


    private void getAllDetailsFromDB(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReferenceFromUrl(ConstantsClass.FIRE_BASE_URL).child(uid);
        ref.addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                            mHomeTrackMemberList.add(userSnapshot.getValue(HomeTrackMember.class));
                        }

                        mBaseTrackerAdapter.notifyDataSetChanged();

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        //handle databaseError
                    }
                });

    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        // This makes sure that the host activity has implemented the callback interface
        // If not, it throws an exception
        try
        {
            mHomeTrackerClicked = (HomeTrackerClicked) context;
        }
        catch (ClassCastException e)
        {
            throw new ClassCastException(context.toString()+ " must implement OnImageClickListener");
        }
    }

}
