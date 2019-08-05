package cehs0703.seo.travel.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;


import cehs0703.seo.travel.Adapter.MyRecyclerAdpater;
import cehs0703.seo.travel.ListVO.Tab2ItemVO;
import cehs0703.seo.travel.R;


public class Tab2Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerView recyclerView ;
    MyRecyclerAdpater adapter;
    ArrayList<Tab2ItemVO> list;
    String mUrl[]={"https://tour.chungnam.go.kr/Img/kr/sub1/taste_img01.jpg" ,
            "https://tour.chungnam.go.kr/Img/kr/sub1/taste_img02.jpg" ,
            "https://tour.chungnam.go.kr/Img/kr/sub1/taste_img03.jpg",
            "https://tour.chungnam.go.kr/Img/kr/sub1/taste_img04.jpg",
            "https://tour.chungnam.go.kr/Img/kr/sub1/taste_img05.jpg",
            "https://tour.chungnam.go.kr/Img/kr/sub1/taste_img06.jpg",
            "https://tour.chungnam.go.kr/Img/kr/sub1/taste_img07.jpg",
            "https://tour.chungnam.go.kr/Img/kr/sub1/taste_img08.jpg",
            "https://tour.chungnam.go.kr/Img/kr/sub1/taste_img09.jpg",
            "https://tour.chungnam.go.kr/Img/kr/sub1/taste_img11.jpg",
            "https://tour.chungnam.go.kr/Img/kr/sub1/taste_img12.jpg",
            "https://tour.chungnam.go.kr/Img/kr/sub1/taste_img13.jpg",
            "https://tour.chungnam.go.kr/Img/kr/sub1/taste_img15.jpg",
            "https://tour.chungnam.go.kr/Img/kr/sub1/taste_img16.jpg",
            "https://tour.chungnam.go.kr/Img/kr/sub1/taste_img17.jpg",
            "https://tour.chungnam.go.kr/Img/kr/sub1/taste_img18.jpg",
            "https://tour.chungnam.go.kr/Img/kr/sub1/taste_img19.jpg",
            "https://tour.chungnam.go.kr/Img/kr/sub1/taste_img20.jpg",
            "https://tour.chungnam.go.kr/Img/kr/sub1/taste_img21.jpg",
            "https://tour.chungnam.go.kr/Img/kr/sub1/taste_img22.jpg",
            "https://tour.chungnam.go.kr/Img/kr/sub1/taste_img23.jpg",
            "https://tour.chungnam.go.kr/Img/kr/sub1/taste_img24.jpg",
            "https://tour.chungnam.go.kr/Img/kr/sub1/taste_img26.jpg",
            "https://tour.chungnam.go.kr/Img/kr/sub1/taste_img27.jpg",
            "https://tour.chungnam.go.kr/Img/kr/sub1/taste_img28.jpg",
            "https://tour.chungnam.go.kr/Img/kr/sub1/taste_img29.jpg",
            "https://tour.chungnam.go.kr/Img/kr/sub1/taste_img30.jpg",
            "https://tour.chungnam.go.kr/Img/kr/sub1/taste_img31.jpg",
            "https://tour.chungnam.go.kr/Img/kr/sub1/taste_img33.jpg",

    };
    public Tab2Fragment() {
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
    public static Tab2Fragment newInstance(String param1, String param2) {
        Tab2Fragment fragment = new Tab2Fragment();
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
        View view=inflater.inflate(R.layout.fragment_tab2,container,false);
        recyclerView =(RecyclerView) view.findViewById(R.id.Tab2List);
        //recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        Toast.makeText(getContext(),"로딩중입니다..잠시만 기다려주세요..!",Toast.LENGTH_LONG).show();


//        AdView mAdView;
//        MobileAds.initialize(getActivity(), getString(R.string.banner_ad_unit_id));
//        mAdView = view.findViewById(R.id.adViewlist2);
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










        RecyclerView.LayoutManager layoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        list=new ArrayList<>();
        adapter=new MyRecyclerAdpater(list,getActivity());
        recyclerView.setAdapter(adapter);
        FoodHtmlParser HtmlTask=new FoodHtmlParser();
        HtmlTask.execute();
        return view;
    }


    private class FoodHtmlParser extends AsyncTask<Void,Void,Document> {
        @Override
        protected Document doInBackground(Void... voids) {
            String murl="https://tour.chungnam.go.kr/html/kr/sub08/sub08_03.html";
            Document doc=null;
            try {
                doc= Jsoup.connect(murl).get();
            } catch (Exception e) {
                e.printStackTrace();
                Log.d("seo-frag2","error");
            }
            return doc;
        }

        @Override
        protected void onPostExecute(Document s) {
            try{
                Elements elements=s.select("section #txt ul li a .ct_hover");
                int i=0;
                for(Element e:elements) {
                    if(i>30)break;
                    list.add(new Tab2ItemVO(mUrl[i],e.select(".cate").get(0).text()+e.select("b").get(0).text(),e.select("em").get(0).text()));
                    i++;
                    Log.d("seo-frag2", e.select(".cate").get(0).text()+e.select("b").get(0).text());
                }
                adapter.notifyDataSetChanged();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
