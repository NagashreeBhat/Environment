package com.example.environmentalchanges.Activities;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.navigation.NavigationView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.environmentalchanges.Modules.ActivityListUserAdapter;
import com.example.environmentalchanges.Modules.CalenderViewAdapter;
import com.example.environmentalchanges.R;

import java.util.ArrayList;

public class ActivityLog extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

        DrawerLayout drawer;
        Toolbar toolbar;
        CalenderViewAdapter calenderViewAdapter;
        RecyclerView recyclerView;
        ArrayList<String> calenderNames = new ArrayList<>();
        ArrayList<String> names= new ArrayList<>();
        ArrayList<String> descrption = new ArrayList<>();
        ActivityListUserAdapter activityListUserAdapter;
@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       getCalenderNames();
       getActivityUser();


        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
        this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        }

@Override
public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
        drawer.closeDrawer(GravityCompat.START);
        } else {
        super.onBackPressed();

        }
        }

@Override
public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.profile_page, menu);
        return true;
        }

@Override
public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
        return true;
        }

        return super.onOptionsItemSelected(item);
        }

@SuppressWarnings("StatementWithEmptyBody")
@Override
public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profile) {
        Thread profile = new Thread(){
@Override
public void run(){
        Intent profileUser = new Intent(ActivityLog.this, ProfilePage.class);
        profileUser.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(profileUser);
        finish();

        }
        };
        profile.start();
        } else if (id == R.id.nav_activitylog) {
        Thread activity = new Thread(){
@Override
public void run(){
        Intent activityLog = new Intent(ActivityLog.this,ActivityLog.class);
        activityLog.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(activityLog);
        finish();

        }
        };
        activity.start();

        } else if (id == R.id.nav_environmentFootPrint) {
            Thread envi = new Thread() {
                @Override
                public void run() {
                    Intent envilog = new Intent(ActivityLog.this, EnvirontmentFootprint.class);
                    envilog.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(envilog);
                    finish();

                }
            };
            envi.start();
        }

        else if (id == R.id.nav_growPlant) {

        } else if (id == R.id.nav_findFriends) {

        } else if (id == R.id.nav_signOut) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
        }
        public void getCalenderNames(){
                recyclerView = findViewById(R.id.calenderrecycler);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerView.setLayoutManager(linearLayoutManager);
            calenderViewAdapter = new CalenderViewAdapter(this,calenderNames);
               calenderNames.add("Jan");
                calenderNames.add("Feb");
                calenderNames.add("Mar");
                calenderNames.add("Apr");
                calenderNames.add("May");
                calenderNames.add("June");
                calenderNames.add("July");
                calenderNames.add("Aug");
                calenderNames.add("Sep");
                calenderNames.add("Oct");
                calenderNames.add("Nov");
                calenderNames.add("Dec");

              recyclerView.setAdapter(calenderViewAdapter);
              calenderViewAdapter.notifyDataSetChanged();


        }
        public void getActivityUser(){
            recyclerView = findViewById(R.id.listrecycler);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(linearLayoutManager);
            activityListUserAdapter = new ActivityListUserAdapter(this,names,descrption);
            names.add("Plastic Usage");
            descrption.add("This week");
            names.add("Water Usage");
            descrption.add("This week");
            names.add("Electricity Usage");
            descrption.add("This week");
            names.add("Fuel Usage");
            descrption.add("Copenhagen,Denmark");

            recyclerView.setAdapter(activityListUserAdapter);
            activityListUserAdapter.notifyDataSetChanged();
        }
}
