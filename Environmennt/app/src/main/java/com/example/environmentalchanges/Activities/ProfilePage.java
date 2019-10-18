package com.example.environmentalchanges.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import com.google.android.material.navigation.NavigationView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.example.environmentalchanges.R;

public class ProfilePage extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
ImageView toolimage;
DrawerLayout drawer;
Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolimage = findViewById(R.id.toolimage);


         drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
       getSupportActionBar().hide();
        toolimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                   drawer.openDrawer(Gravity.LEFT);

            }
        });
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
        if(id == R.id.action_search){
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
                    Intent profileUser = new Intent(ProfilePage.this,ProfilePage.class);
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
                    Intent activityLog = new Intent(ProfilePage.this, ActivityLog.class);
                    activityLog.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(activityLog);
                    finish();

                }
            };
            activity.start();

        } else if (id == R.id.nav_environmentFootPrint) {
            Thread envi = new Thread(){
                @Override
                public void run(){
                    Intent envilog = new Intent(ProfilePage.this,EnvirontmentFootprint.class);
                    envilog.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(envilog);
                    finish();

                }
            };
            envi.start();

        } else if (id == R.id.nav_growPlant) {

        } else if (id == R.id.nav_findFriends) {

        } else if (id == R.id.nav_signOut) {

        }else if(id== R.id.nav_leaderBoard){

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
