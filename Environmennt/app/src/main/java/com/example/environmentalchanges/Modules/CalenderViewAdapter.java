package com.example.environmentalchanges.Modules;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.environmentalchanges.R;



import java.util.ArrayList;

public class CalenderViewAdapter extends RecyclerView.Adapter<CalenderViewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";

    //vars
    Context context;
    private ArrayList<String> calenderDates = new ArrayList<>();



    public CalenderViewAdapter(Context context,  ArrayList<String> calenderDates) {
        this.context = context;
        this.calenderDates = calenderDates;

    }

    @Override
    public CalenderViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.calenderdates, parent, false);
        return new CalenderViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CalenderViewAdapter.ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        holder.calenderdates.setText(calenderDates.get(position));



    }

    @Override
    public int getItemCount() {
        return calenderDates.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
       TextView calenderdates;


        public ViewHolder(View itemView) {
            super(itemView);
            calenderdates = itemView.findViewById(R.id.calenderText);




        }
    }



}
