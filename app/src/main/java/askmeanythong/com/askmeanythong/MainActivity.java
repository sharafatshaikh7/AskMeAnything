package askmeanythong.com.askmeanythong;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    ActionBar actionBar;
    private android.support.v4.app.ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    boolean mSlideState;
    ImageView drawerImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar=getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        LayoutInflater inflater= (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.textview,null);
        actionBar.setCustomView(view);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        drawerImageView=(ImageView)view.findViewById(R.id.drawer_button);
        drawerImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(mDrawerLayout.isDrawerOpen(GravityCompat.START))
                {
                    mDrawerLayout.closeDrawer(GravityCompat.START);
                }
                else
                {
                    mDrawerLayout.openDrawer(GravityCompat.START);
                }

            }
        });





        NavigationView navigationView = (NavigationView) findViewById(R.id.design_navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {

                    case R.id.question:
                        startActivity(new Intent(MainActivity.this,AskQuestion.class));
                        item.setCheckable(true);
                        getSupportActionBar().setTitle("Ask Question");
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.Filtermenu:
                        startActivity(new Intent(MainActivity.this,Filter.class));
                        getSupportActionBar().setTitle("Filter");
                        item.setCheckable(true);
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.Profile:
                        startActivity(new Intent(MainActivity.this,Profile.class));
                        getSupportActionBar().setTitle("Profile");
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.Share:
                        try
                        {
                            Intent shareintent=new Intent();
                            shareintent.setAction(shareintent.ACTION_SEND);
                            shareintent.putExtra(Intent.EXTRA_TEXT,"www.google.com");
                            startActivity(shareintent);

                        }catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                        item.setCheckable(true);
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.logout:



                        break;

                }



                return true;
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatin);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.filter:
                startActivity(new Intent(MainActivity.this,Filter.class));
                break;
            case R.id.referesh:
                startActivity(new Intent(MainActivity.this,AskQuestion.class));
                break;
            case R.id.exit:
                MainActivity.this.finish();
                break;


        }
        return super.onOptionsItemSelected(item);
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
/*
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id)
        {
            case R.id.question:
                startActivity(new Intent(MainActivity.this,AskQuestion.class));
                drawer.closeDrawer(GravityCompat.START);
                break;
            case R.id.Filtermenu:
                startActivity(new Intent(MainActivity.this,Filter.class));
                mDrawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.Profile:
                startActivity(new Intent(MainActivity.this,Profile.class));
                mDrawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.Share:
                break;

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }*/
}
