package cehs0703.seo.travel.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import cehs0703.seo.travel.R;


public class TripExp3Activity extends AppCompatActivity {
    ImageView mImage;
    TextView telTextView;
    TextView locTextView;
    TextView decTextView;
    String s2 = "";
    String s3 = ""; //위도
    String s4 = ""; //경도
    String s6;
   // private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_exp3);
//        MobileAds.initialize(this, getString(R.string.banner_ad_unit_id));
//        mAdView = findViewById(R.id.adView3);
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



        Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);
        getSupportActionBar().setIcon(R.drawable.mloooooooog);
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

        mImage=(ImageView)findViewById(R.id.Exp3Iamge);
        telTextView=(TextView)findViewById(R.id.Exp3PhoneNum);
        locTextView=(TextView)findViewById(R.id.Exp3Loc);
        decTextView=(TextView)findViewById(R.id.Exp3Content);
        decTextView.setMovementMethod(new ScrollingMovementMethod());
        telTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(s2.equals("")||s2.equals(null))){
                    Toast.makeText(getApplicationContext(),s6+" tel : "+s2,Toast.LENGTH_LONG).show();
                    String tel = "tel:"+s2;
                    startActivity(new Intent("android.intent.action.DIAL", Uri.parse(tel)));
                }
            }
        });
        locTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i=new Intent(TripExp3Activity.this,TripExp3SubActivity.class);
//                i.putExtra("Lat",s3);
//                i.putExtra("Loc",s4);
//                Log.d("seo-@@@exp3",s3+s4);
//                startActivity(i); //동작코드
//                Frag3ClickDialog dialog=new Frag3ClickDialog(getApplicationContext(),s3,s4,TripExp3Activity.this);
//                dialog.show(); //동작실패
            }
        });


        CalltoHtml task=new CalltoHtml();
        task.execute();
    }

    private class CalltoHtml extends AsyncTask<Void,Void, Document> {

        @Override
        protected Document doInBackground(Void... voids) {
            Intent i=getIntent();
            String title=i.getStringExtra("Exp3title");
            Document doc=null;

            try {
                title=new String(title.getBytes("utf-8"));
                Log.d("seo-Here is Exp3",title);

                String HtmlUrl="http://tour.chungnam.go.kr/_prog/openapi/?func=tour&sval="+title;
                URL url=new URL(HtmlUrl);
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                doc = db.parse(new InputSource(url.openStream()));
                doc.getDocumentElement().normalize();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return  doc;
        }

        @Override
        protected void onPostExecute(Document document) {
            String s1 = "";

            String s5= "";
            NodeList nodeList = document.getElementsByTagName("item");
            for(int i=0;i<nodeList.getLength();i++){
                Node node = nodeList.item(i);
                Element fstElmnt = (Element) node;
                NodeList nm = fstElmnt.getElementsByTagName("list_img");
                s1 =  nm.item(0).getChildNodes().item(0).getNodeValue() ;
                //넘겨줄 번호
                NodeList loc = fstElmnt.getElementsByTagName("tel");
                s2 =  loc.item(0).getChildNodes().item(0).getNodeValue() ;
                //제목 만약 천안 공주 안 붙어있으면 []
                NodeList lat=fstElmnt.getElementsByTagName("lat");
                s3=lat.item(0).getChildNodes().item(0).getNodeValue();

                NodeList lng=fstElmnt.getElementsByTagName("lng");
                s4=lng.item(0).getChildNodes().item(0).getNodeValue();
                //실질적 주소
                NodeList list_img=fstElmnt.getElementsByTagName("desc");
                s5=list_img.item(0).getChildNodes().item(0).getNodeValue();

                NodeList list_nm=fstElmnt.getElementsByTagName("nm");
                s6=list_nm.item(0).getChildNodes().item(0).getNodeValue();
            }
            Glide.with(getApplicationContext()).load(s1).into(mImage);
            if(s5.contains("&#039;")){
                s5=s5.replace("&#039;","");
            }
            decTextView.setText(s5);
            Log.d("seo-TripExp1",s2);
            if(s2.contains(",")){
                int idx=s2.indexOf(",");
                s2=s2.substring(0,idx);
            }
            else if(s2.contains("~")){
                int idx=s2.indexOf("~");
                s2=s2.substring(0,idx);
                Log.d("seo-Trip",idx+"마곡사번호");
            }
            else if(s2.contains("/")){
                int idx=s2.indexOf(",");
                s2=s2.substring(0,idx);
            }
            else if(s2.contains("매표소")){
                int idx=s2.indexOf("매표소");
                s2=s2.substring(idx);
                //Log.d("seo-Trip",idx+"매표소");
            }
            s2=s2.replaceAll("[^0-9]","");

            //Log.d("seo-TripExp2",s2);

            if(s2.length()==8){
                s2=s2.substring(0,4)+"-"+s2.substring(4);
            }
            else if(s2.length()==10){
                s2=s2.substring(0,3)+"-"+s2.substring(3,6)+"-"+s2.substring(6);
            }
            else if(s2.length()==11){
                s2=s2.substring(0,3)+"-"+s2.substring(3,7)+"-"+s2.substring(7);
            }
            else if(s2.length()==20){
                s2=s2.substring(0,3)+"-"+s2.substring(3,6)+"-"+s2.substring(6,10);
            }
            //Log.d("seo-TripExp3",s2);
            //Log.d("seo-TripExp3:제목",s6);
        }
    }
}
