package cehs0703.seo.travel;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v7.app.ActionBar;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import cehs0703.seo.travel.Activity.DevelopInfo;
import cehs0703.seo.travel.Fragment.Tab1Fragment;
import cehs0703.seo.travel.Fragment.Tab2Fragment;
import cehs0703.seo.travel.Fragment.Tab3Fragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, ActionBar.TabListener, TabLayout.BaseOnTabSelectedListener {
    TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setIcon(R.drawable.mloooooooog);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        // ↓툴바의 홈버튼의 이미지를 변경(기본 이미지는 뒤로가기 화살표)
//        getSupportActionBar().setHomeAsUpIndicator(R.drawable.list);

        //tab 1 tab2 tab3 를 위한 tab layout 사용
        tabLayout=(TabLayout)findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("충남30경"));
        tabLayout.addTab(tabLayout.newTab().setText("충남30미"));
        tabLayout.addTab(tabLayout.newTab().setText("충남특색지"));
        tabLayout.addOnTabSelectedListener(this);


        View view = getWindow().getDecorView();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (view != null) {
                // 23 버전 이상일 때 상태바 하얀 색상에 회색 아이콘 색상을 설정
                view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                getWindow().setStatusBarColor(Color.parseColor("#ffffff"));
            }
        }else if (Build.VERSION.SDK_INT >= 21) {
            // 21 버전 이상일 때
            getWindow().setStatusBarColor(Color.WHITE);
        }
//        ActionBar actionBar=getSupportActionBar();
//        //actionBar.setTitle(Html.fromHtml("<font color='#000000'>ActionBarTitle </font>"));
//        //actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorWhite)));
//        actionBar.setDisplayHomeAsUpEnabled(false);			//액션바 아이콘을 업 네비게이션 형태로 표시합니다.
//        actionBar.setDisplayShowTitleEnabled(false);		//액션바에 표시되는 제목의 표시유무를 설정합니다.
//        actionBar.setDisplayShowHomeEnabled(false);
//        View mCustomView= LayoutInflater.from(this).inflate(R.layout.actionbar,null);
//        actionBar.setCustomView(mCustomView);





        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "개발자이메일:chkm0703@gmail.com", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.MainFrame, new Tab1Fragment());
        fragmentTransaction.commit();

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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_share) {
            // Handle the camera action
        } else if (id == R.id.nav_send) {
            Intent i =new Intent(MainActivity.this, DevelopInfo.class);
            startActivity(i);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }




    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) { //화면전환 코드
        switch (tab.getPosition()){
            case 0:
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.MainFrame, new Tab1Fragment());
                fragmentTransaction.commit();
                break;
            case 1:
                FragmentManager fragmentManager1 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                fragmentTransaction1.replace(R.id.MainFrame, new Tab2Fragment());
                fragmentTransaction1.commit();
                break;
            case 2:

                FragmentManager fragmentManager2 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                fragmentTransaction2.replace(R.id.MainFrame, new Tab3Fragment());
                fragmentTransaction2.commit();
                break;
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}