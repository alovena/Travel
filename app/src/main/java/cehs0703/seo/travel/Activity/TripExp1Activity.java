package cehs0703.seo.travel.Activity;
import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
//
//import com.google.android.gms.ads.AdListener;
//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.AdView;
//import com.google.android.gms.ads.MobileAds;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.util.regex.Pattern;
//
//import cehs0703.seo.chunamtravel.Adapter.CustomPagerAdapter;
//import cehs0703.seo.chunamtravel.DaumMapSchemeURL;
//import cehs0703.seo.chunamtravel.Dialog.Frag1ClickDialog;
//import cehs0703.seo.chunamtravel.R;
import cehs0703.seo.travel.Adapter.CustomPagerAdapter;
import cehs0703.seo.travel.R;

public class TripExp1Activity extends AppCompatActivity implements View.OnClickListener {
    int listindex=0;
    int imageindex=0;
    TextView contentText;
    TextView TelText;
    TextView LocText;
    ViewPager viewPager;
    // private AdView mAdView;
    String tel;
    String Loc="";
    static public final int CONTACT = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_exp1);

//        MobileAds.initialize(this, getString(R.string.banner_ad_unit_id));
//        mAdView = findViewById(R.id.adView);
//
//        AdRequest adRequest = new AdRequest.Builder().build();
//
//        mAdView.loadAd(adRequest);
//        // 광고가 제대로 로드 되는지 테스트 하기 위한 코드입니다.
//
//        mAdView.setAdListener(new AdListener() {
//
//            @Override
//
//            public void onAdLoaded() {
//
//                // Code to be executed when an ad finishes loading.
//
//                // 광고가 문제 없이 로드시 출력됩니다.
//
//                Log.d("@@@", "onAdLoaded");
//
//            }
//
//
//
//            @Override
//
//            public void onAdFailedToLoad(int errorCode) {
//
//                // Code to be executed when an ad request fails.
//
//                // 광고 로드에 문제가 있을시 출력됩니다.
//
//                Log.d("@@@", "onAdFailedToLoad " + errorCode);
//
//            }
//
//
//
//            @Override
//
//            public void onAdOpened() {
//
//                // Code to be executed when an ad opens an overlay that
//
//                // covers the screen.
//
//            }
//
//
//
//            @Override
//
//            public void onAdClicked() {
//
//                // Code to be executed when the user clicks on an ad.
//
//            }
//
//
//
//            @Override
//
//            public void onAdLeftApplication() {
//
//                // Code to be executed when the user has left the app.
//
//            }
//
//
//
//            @Override
//
//            public void onAdClosed() {
//
//                // Code to be executed when the user is about to return
//
//                // to the app after tapping on an ad.
//
//            }
//
//        });
//




        Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setIcon(R.drawable.mloooooooog);
        Intent intent=getIntent();
        listindex=intent.getIntExtra("list-index",0);
        imageindex=intent.getIntExtra("list-index",0);

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

        Log.d("seo-exp1",imageindex+1+"");

        if(imageindex==13){
            imageindex=100;

        }
        else if(imageindex>13){
            imageindex-=1;
        }
        String image[]={"https://tour.chungnam.go.kr/Img/kr/sub8/cate"+(imageindex+1)+"_img1.jpg",
                "https://tour.chungnam.go.kr/Img/kr/sub8/cate"+(imageindex+1)+"_img2.jpg",
                "https://tour.chungnam.go.kr/Img/kr/sub8/cate"+(imageindex+1)+"_img3.jpg",
                "https://tour.chungnam.go.kr/Img/kr/sub8/cate"+(imageindex+1)+"_img4.jpg",
                "https://tour.chungnam.go.kr/Img/kr/sub8/cate"+(imageindex+1)+"_img5.jpg"};




        contentText=(TextView)findViewById(R.id.Exp1Content) ;
        contentText.setMovementMethod(new ScrollingMovementMethod());


        TelText=(TextView)findViewById(R.id.Exp1PhoneNum) ;
        LocText=(TextView)findViewById(R.id.Exp1Loc) ;
        TelText.setOnClickListener(this);
        LocText.setOnClickListener(this);
        viewPager=(ViewPager)findViewById(R.id.Exp1Iamge) ;


        if (viewPager != null) {
            viewPager.setAdapter(new CustomPagerAdapter(this, image));
        }

        GetHtmlTask task=new GetHtmlTask();
        task.execute();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Exp1Loc:
                Toast.makeText(getApplicationContext(),"준비중입니다..",Toast.LENGTH_LONG).show();
                break;
            case R.id.Exp1PhoneNum:
                String NumText=tel;
                //Log.d("seoseoseo",NumText);
                if(!(NumText.equals("")||NumText.equals(null))){
                    String tel = "tel:"+NumText;
                    Log.d("seo-Exp1",tel);
                    startActivity(new Intent("android.intent.action.DIAL", Uri.parse(tel)));
                }
                break;

        }
    }
//    public Intent onRoute(String mloc){
//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        intent.setData(Uri.parse(mloc));
//        DaumMapSchemeURL daummap = new DaumMapSchemeURL(getApplicationContext(), intent) {
//            @Override
//            public boolean canOpenDaummapURL() {
//                return super.canOpenDaummapURL();
//            }
//        };
//
//        if(daummap.existDaummapApp()){
//            return intent;
//        } else {
//            DaumMapSchemeURL.openDaummapDownloadPage(getApplicationContext());
//        }
//        return null;
//    }

    private class GetHtmlTask extends AsyncTask<Void,Void, Document> {

        @Override
        protected Document doInBackground(Void... voids) {
            String url="https://tour.chungnam.go.kr/html/kr/sub08/ajax/sub0802_"+(listindex+1)+".html";
            org.jsoup.nodes.Document doc=null;

            try {
                doc= Jsoup.connect(url).get();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return doc;
        }

        @Override
        protected void onPostExecute(Document document) {
            try{
                Elements elements=document.select(".att_detail_info .innerbox p");
                Elements elements2=document.select(".att_detail_info .innerbox ul li");
                String content="";
                int i=0;
                String TelNum="";


                for(Element e:elements){
                    Log.d("seo-TripExp1",e.text());
                    content+=e.text()+"\n";
                }
                for(Element e:elements2){
                    if(i==0){
                        Loc=e.text();
                        Log.d("seo-TripExp1",Loc);
                        if(Loc.contains("주소")){
                            Loc=Loc.substring(2);
                            Log.d("seo-TripExp1","악!");
                        }
                        //Loc=Loc.substring(2);
                        Log.d("seo-TripExp1",Loc);

                    }
                    if(i==1){
                        TelNum=e.text();
                        //TelNum.replace([가-하])
                        Log.d("seo-TripExp0",TelNum);
                        if(TelNum.contains("~")){
                            int idx=TelNum.indexOf("~");
                            TelNum=TelNum.substring(0,idx);
                        }
                        else if(TelNum.contains(",")){
                            int idx=TelNum.indexOf(",");
                            TelNum=TelNum.substring(0,idx);
                        }
                        tel=TelNum.replaceAll("[^0-9]","");

                        Log.d("seo-TripExp1",tel);

                        if(tel.length()==8){
                            tel=tel.substring(0,4)+"-"+tel.substring(4);
                        }
                        else if(tel.length()==10){
                            tel=tel.substring(0,3)+"-"+tel.substring(3,6)+"-"+tel.substring(6);
                        }
                        Log.d("seo-TripExp2",tel);


                    }
                    i++;
                }
                contentText.setText(content);
                //TelText.setText(TelNum);
                //LocText.setText(Loc);


            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}
