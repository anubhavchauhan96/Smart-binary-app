package com.example.anubhavchauhan.smartbinarytraders;

import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private WebView myWebView;

    private ProgressDialog progressDialog;
    private ActionBarDrawerToggle mToggle;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");

        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawerLayout);
        mToggle= new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        myWebView = (WebView)findViewById(R.id.webView);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.loadUrl("http://www.smartbinarytraders.com");
        myWebView.setWebViewClient(new WebViewClient());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = (NavigationView)findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);




        }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        if(myWebView.canGoBack()) {
            myWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.aboutMe) {
            progressDialog.show();
            // Handle the about tme action
            startActivity(new Intent(getApplicationContext(),Main2Activity.class));
            progressDialog.dismiss();
        }   else if(id == R.id.smartBinary){
            progressDialog.show();
            myWebView.loadUrl("https://www.smartbinarytraders.com");
            progressDialog.dismiss();
        }

        else if (id == R.id.instagram) {
            progressDialog.show();
            myWebView.loadUrl("https://www.instagram.com/smartbinarytraders/");
            progressDialog.dismiss();
        } else if (id == R.id.twitter) {
            progressDialog.show();
            myWebView.loadUrl("https://mobile.twitter.com/TradersSmart");
            progressDialog.dismiss();
        } else if (id == R.id.facebook) {
            progressDialog.show();
            myWebView.loadUrl("https://www.facebook.com/smartbinarytrader/");
            progressDialog.dismiss();
        }

        return false;
    }
}
