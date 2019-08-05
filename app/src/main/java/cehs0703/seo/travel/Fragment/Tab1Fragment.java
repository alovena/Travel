package cehs0703.seo.travel.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

import cehs0703.seo.travel.Adapter.Tab1Adapter;
import cehs0703.seo.travel.ListVO.Tab1ItemVO;
import cehs0703.seo.travel.R;


public class Tab1Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ListView listView;
    Tab1Adapter adapter;
    ArrayList<Tab1ItemVO> list;
    String imageUrl[]={"https://tour.chungnam.go.kr/Img/kr/sub8/cate1_img1.jpg","https://tour.chungnam.go.kr/Img/kr/sub8/cate2_img1.jpg",
            "https://tour.chungnam.go.kr/Img/kr/sub8/cate3_img1.jpg","https://tour.chungnam.go.kr/Img/kr/sub8/cate4_img1.jpg",
            "https://tour.chungnam.go.kr/Img/kr/sub8/cate5_img1.jpg","https://tour.chungnam.go.kr/Img/kr/sub8/cate6_img1.jpg",
            "https://tour.chungnam.go.kr/Img/kr/sub8/cate7_img1.jpg","https://tour.chungnam.go.kr/Img/kr/sub8/cate8_img1.jpg",
            "https://tour.chungnam.go.kr/Img/kr/sub8/cate9_img1.jpg","https://tour.chungnam.go.kr/Img/kr/sub8/cate10_img1.jpg",
            "https://tour.chungnam.go.kr/Img/kr/sub8/cate11_img1.jpg","https://tour.chungnam.go.kr/Img/kr/sub8/cate12_img1.jpg",
            "https://tour.chungnam.go.kr/Img/kr/sub8/cate13_img1.jpg","https://tour.chungnam.go.kr/Img/kr/common/no_img.jpg",
            "https://tour.chungnam.go.kr/Img/kr/sub8/cate14_img1.jpg","https://tour.chungnam.go.kr/Img/kr/sub8/cate15_img1.jpg",
            "https://tour.chungnam.go.kr/Img/kr/sub8/cate16_img1.jpg","https://tour.chungnam.go.kr/Img/kr/sub8/cate17_img1.jpg",
            "https://tour.chungnam.go.kr/Img/kr/sub8/cate18_img1.jpg","https://tour.chungnam.go.kr/Img/kr/sub8/cate19_img1.jpg",
            "https://tour.chungnam.go.kr/Img/kr/sub8/cate20_img1.jpg","https://tour.chungnam.go.kr/Img/kr/sub8/cate21_img1.jpg",
            "https://tour.chungnam.go.kr/Img/kr/sub8/cate22_img1.jpg","https://tour.chungnam.go.kr/Img/kr/sub8/cate23_img1.jpg",
            "https://tour.chungnam.go.kr/Img/kr/sub8/cate24_img1.jpg","https://tour.chungnam.go.kr/Img/kr/sub8/cate25_img1.jpg",
            "https://tour.chungnam.go.kr/Img/kr/sub8/cate26_img1.jpg","https://tour.chungnam.go.kr/Img/kr/sub8/cate27_img1.jpg",
            "https://tour.chungnam.go.kr/Img/kr/sub8/cate28_img1.jpg","https://tour.chungnam.go.kr/Img/kr/sub8/cate29_img1.jpg"
    };
    //private AdView mAdView;
    public Tab1Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Tab2Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Tab1Fragment newInstance(String param1, String param2) {
        Tab1Fragment fragment = new Tab1Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_tab1,container,false);
        listView=(ListView)view.findViewById(R.id.Tab1List);
//
//        MobileAds.initialize(getActivity(), getString(R.string.admob_app_id));
//        mAdView = view.findViewById(R.id.adViewlist1);
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




        list=new ArrayList<>();
        adapter=new Tab1Adapter(list);
        Tab1Fragment.HtmlParser HtmlTask=new Tab1Fragment.HtmlParser();
        HtmlTask.execute();
        return view;
    }


    private class HtmlParser extends AsyncTask<Void,Void, org.jsoup.nodes.Document> {
        @Override
        protected org.jsoup.nodes.Document doInBackground(Void... voids) {
            String murl="https://tour.chungnam.go.kr/html/kr/sub08/sub08_02.html";
            org.jsoup.nodes.Document doc=null;
            //String subUrl="https://tour.chungnam.go.kr/html/kr/sub08/ajax/sub0802_1.html";
            try {
                doc= Jsoup.connect(murl).get();
            } catch (Exception e) {
                e.printStackTrace();
                Log.d("seo-frag1","error");
            }
            return doc;
        }

        @Override
        protected void onPostExecute(Document s) {
            try{
                Elements elements=s.select(".catewrap .mtab a > span");
                int i=0;
                for(Element e:elements){
                    adapter.addVO(imageUrl[i],e.text());

                    i++;
                    if (i>=30)break;
                    Log.d("seo-frag1",e.text());
                }
                listView.setAdapter(adapter);
            }catch (Exception e){
                Toast.makeText(getContext(),"네트워크를 확인해주세요.!",Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }
        }
    }
}
