package com.example.keren.liveguardgps;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import VO.HomeTrackMember;

/**
 * Created by amirlubashevsky on 09/03/2018.
 */

public class BaseTrackerAdapter extends RecyclerView.Adapter<BaseTrackerAdapter.ViewHolder> {

    private List<HomeTrackMember> mHomeTrackMemberList;
    private OnTrackerClickListener mOnTrackerClickListener = null;


    public interface OnTrackerClickListener{
        void onTrackerClicked(HomeTrackMember homeTrackMember);
    }

    BaseTrackerAdapter(List<HomeTrackMember> homeTrackMemberList){
        mHomeTrackMemberList = homeTrackMemberList;
    }


    public void setmOnTrackerClickListener(OnTrackerClickListener onTrackerClickListener){
        mOnTrackerClickListener = onTrackerClickListener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView row_tracker_name;
        private ImageView row_tracker_image;
        private View layout;
        public ViewHolder(View itemView) {
            super(itemView);
            layout = itemView;
            row_tracker_name = itemView.findViewById(R.id.row_tracker_name);
            row_tracker_image = itemView.findViewById(R.id.row_tracker_image);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewGroup rowView = (ViewGroup) LayoutInflater.from(parent.getContext()).inflate(R.layout.row_tracker_item, parent, false);
        ViewHolder vh = new ViewHolder(rowView);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.row_tracker_name.setText(mHomeTrackMemberList.get(position).getmName());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mOnTrackerClickListener != null) {
                    mOnTrackerClickListener.onTrackerClicked(mHomeTrackMemberList.get(position));
                }
            }
        });

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return mHomeTrackMemberList.size();
    }

}
