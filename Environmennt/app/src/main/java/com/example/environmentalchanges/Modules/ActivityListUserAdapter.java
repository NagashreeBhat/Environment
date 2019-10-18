package com.example.environmentalchanges.Modules;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.environmentalchanges.R;

import java.util.ArrayList;

public class ActivityListUserAdapter extends RecyclerView.Adapter<ActivityListUserAdapter.ViewHolder> {

    private static final String TAG = "Activity User";

    //vars
    Context context;
    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<String> images = new ArrayList<>();
    private ArrayList<String> descrption = new ArrayList<>();



    public ActivityListUserAdapter(Context context,  ArrayList<String> names,ArrayList<String> descrption) {
        this.context = context;
        this.names = names;

        this.descrption = descrption;

    }

    @Override
    public ActivityListUserAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_activity, parent, false);
        return new ActivityListUserAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ActivityListUserAdapter.ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");
       holder.name.setText(names.get(position));
       holder.image.setImageResource(R.drawable.profileimage);
       holder.descrption.setText(descrption.get(position));




    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,descrption;
        ImageView image;


        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nameUser);
            descrption = itemView.findViewById(R.id.descrption);
            image = itemView.findViewById(R.id.activity_user_image);




        }
    }


}
