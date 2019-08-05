package cehs0703.seo.travel.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;



import cehs0703.seo.travel.Adapter.Tab3Adapter;
import cehs0703.seo.travel.ListVO.Tab3ItemVO;
import cehs0703.seo.travel.R;

public class Tab3Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Tab3Adapter adapter;
    ListView listView;

    public Tab3Fragment() {
        // Required empty public constructor
    }

    public static Tab3Fragment newInstance(String param1, String param2) {
        Tab3Fragment fragment = new Tab3Fragment();
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

        View view = inflater.inflate(R.layout.fragment_tab3,null);
        listView=(ListView)view.findViewById(R.id.Tab3List);


//        AdView mAdView;
//        MobileAds.initialize(getActivity(), getString(R.string.banner_ad_unit_id));
//        mAdView = view.findViewById(R.id.adViewlist3);
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




        ArrayList<Tab3ItemVO> list=new ArrayList<>();

        adapter=new Tab3Adapter(list);

        Tab3Fragment.GetXMLTask task=new Tab3Fragment.GetXMLTask();
        task.execute();


        return  view;
    }
    public class GetXMLTask extends AsyncTask<String,Void, Document> {

        @Override
        protected Document doInBackground(String... strings) {
            URL url;
            Document doc=null;
            try {
                url=new URL("http://tour.chungnam.go.kr/_prog/openapi/?func=tour&start=1&end=75");
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                doc = db.parse(new InputSource(url.openStream()));
                doc.getDocumentElement().normalize();
            } catch (Exception e) {
                Toast.makeText(getActivity(),"에러입니다. 다시 한번 시도해주세요.",Toast.LENGTH_LONG).show();
            }
            return doc;
        }

        @Override
        protected void onPostExecute(Document document) {
            String s1 = "";
            String s2 = "";
            String s3 = "";
            String s4 = "";
            NodeList nodeList = document.getElementsByTagName("item");
            for(int i=0;i<nodeList.getLength();i++){
                Node node = nodeList.item(i);
                Element fstElmnt = (Element) node;
                NodeList nm = fstElmnt.getElementsByTagName("mng_no");
                s1 =  nm.item(0).getChildNodes().item(0).getNodeValue() +"\n";
                //넘겨줄 번호
                NodeList loc = fstElmnt.getElementsByTagName("nm");
                s2 =  loc.item(0).getChildNodes().item(0).getNodeValue() +"\n";
                //제목 만약 천안 공주 안 붙어있으면 []
                NodeList tel=fstElmnt.getElementsByTagName("addr");
                s3=tel.item(0).getChildNodes().item(0).getNodeValue()+"\n";
                //실질적 주소
                NodeList list_img=fstElmnt.getElementsByTagName("list_img");
                s4=list_img.item(0).getChildNodes().item(0).getNodeValue();
                //이미지 링크
                adapter.addVO(s1,s2,s3,s4);
                listView.setAdapter(adapter);
            }
        }
    }

}

