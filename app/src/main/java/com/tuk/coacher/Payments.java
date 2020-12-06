package com.tuk.coacher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.tuk.coacher.cash.MCoacher;

import java.util.HashMap;


public class Payments extends Base implements View.OnClickListener{
    private String access_token;
    private MCoacher mCoacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments);

//        String app_key = getResources().getString(R.string.safaricom_Consumer_Key);
//        String app_secret = getResources().getString(R.string.safaricom_Consumer_Secret);
//        mCoacher = new MCoacher();
//        access_token = mCoacher.authenticate(app_key, app_secret);

        FirebaseAuth auth = FirebaseAuth.getInstance();
        Toolbar toolbar = findViewById(R.id.payments_toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout d_layout = findViewById(R.id.payments_drawable);
        NavigationView nav_view = findViewById(R.id.nav_payments_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, d_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        d_layout.addDrawerListener(toggle);
        toggle.syncState();
        nav_view.bringToFront();
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        startActivity(new Intent(Payments.this, Home.class));
                        break;
                    case R.id.nav_map:
                        startActivity(new Intent(Payments.this, Maps.class));
                        break;
                    case R.id.nav_history:
                        startActivity(new Intent(Payments.this, History.class));
                        break;
                    case R.id.nav_profile:
                        startActivity(new Intent(Payments.this, Profile.class));
                        break;
                    case R.id.nav_logout:
                        auth.signOut();
                        startActivity(new Intent(Payments.this, Login.class));
                        finish();
                        break;
                    default:
                        return false;
                }
                return false;
            }
        });

        if(paymentConfirmed()){



        }
    }

    @Override
    public void onClick(View view) {
//        mCoacher.C2BSimulation(access_token)
    }

    private boolean paymentConfirmed(){
        //fake payments for now
        return true;
    }
}
