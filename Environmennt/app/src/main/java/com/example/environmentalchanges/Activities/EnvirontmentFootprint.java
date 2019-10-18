package com.example.environmentalchanges.Activities;

import android.app.AppComponentFactory;
import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.environmentalchanges.R;

public class EnvirontmentFootprint extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawer;
    Toolbar toolbar;


    ListView listView;
    String mTitle[] = {"Water Footprint", "Plastic Footprint", "Electricity Footprint", "Carbon Footprint", "Sustainability", "Habits"};
    String mDescription[] = {"Log Water usage", "Log Plastic usage", "Log electricity usage", "Log Carbon usage", "Log Sustainability Action", "Log Habit Savings"};
    int mImage[] = {R.drawable.water, R.drawable.plastic, R.drawable.electricity, R.drawable.flame, R.drawable.sustain, R.drawable.habits};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.environment_footprint);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        toolbar.setTitle("Environmental Footprint");
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        listView = findViewById(R.id.environmentlistview);

        MyAdapter adapter = new MyAdapter(this, mTitle, mDescription,mImage);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0) {
                    Toast.makeText(EnvirontmentFootprint.this, "Log Water Usage", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(EnvirontmentFootprint.this, WaterUsage.class);
                    startActivity(intent);

                }
                if(position == 1) {
                    Toast.makeText(EnvirontmentFootprint.this, "Log Plastic Usage", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(EnvirontmentFootprint.this, PlasticUsage.class);
                    startActivity(intent);

                }

                if(position == 2) {
                    Toast.makeText(EnvirontmentFootprint.this, "Log Electicity Usage", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(EnvirontmentFootprint.this, ElectricityUsage.class);
                    startActivity(intent);
                }
                if(position == 3) {
                    Toast.makeText(EnvirontmentFootprint.this, "Log Fuel Usage", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(EnvirontmentFootprint.this, FuelUsage.class);
                    startActivity(intent);
                }
                if(position == 4) {
                    Toast.makeText(EnvirontmentFootprint.this, "Log Sustainability Action", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(EnvirontmentFootprint.this, Sustainability.class);
                    startActivity(intent);
                }
                if(position == 5) {
                    Toast.makeText(EnvirontmentFootprint.this, "Log Habit Savings", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(EnvirontmentFootprint.this, Habits.class);
                    startActivity(intent);
                }
            }
        });

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profile) {
            Thread profile = new Thread(){
                @Override
                public void run(){
                    Intent profileUser = new Intent(EnvirontmentFootprint.this, ProfilePage.class);
                    profileUser.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(profileUser);
                    finish();

                }
            };
            profile.start();
        } else if (id == R.id.nav_environmentFootPrint) {
            Thread envi = new Thread(){
                @Override
                public void run(){
                    Intent envilog = new Intent(EnvirontmentFootprint.this,EnvirontmentFootprint.class);
                    envilog.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(envilog);
                    finish();

                }
            };
            envi.start();

        } else if (id == R.id.nav_activitylog) {

        } else if (id == R.id.nav_growPlant) {

        } else if (id == R.id.nav_findFriends) {

        } else if (id == R.id.nav_signOut) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
//    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//        return false;
//    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];
        int rImage[];

        MyAdapter (Context c, String title[], String description[], int image[]) {
            super(c, R.layout.environmentlistview, R.id.envitextview1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImage = image;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.environmentlistview, parent, false);
            ImageView images = row.findViewById(R.id.enviimage);
            TextView myTitle = row.findViewById(R.id.envitextview1);
            TextView myDescription = row.findViewById(R.id.envitextview2);


            images.setImageResource(rImage[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rTitle[position]);



            return row;
        }
    }
}
