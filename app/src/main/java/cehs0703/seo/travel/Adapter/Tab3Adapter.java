package cehs0703.seo.travel.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import cehs0703.seo.travel.Activity.TripExp3Activity;
import cehs0703.seo.travel.ListVO.Tab3ItemVO;
import cehs0703.seo.travel.R;

public class Tab3Adapter extends BaseAdapter {

    ArrayList<Tab3ItemVO> list=new ArrayList<>();

    public Tab3Adapter(ArrayList<Tab3ItemVO> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.fragment_tab3_list, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        ImageView iconImageView = (ImageView) convertView.findViewById(R.id.Tab_Image33) ;
        //TextView titleTextView = (TextView) convertView.findViewById(R.id.Tab_Text1) ;
        //TextView descTextView = (TextView) convertView.findViewById(R.id.Tab_Text2) ;
        TextView TitleTextView = (TextView) convertView.findViewById(R.id.TabFrag_Text33) ;
        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득


        final Tab3ItemVO listViewItem = list.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        // iconImageView.setImageDrawable(listViewItem.getImg());
        Glide.with(context).load(list.get(position).getImageUrl()).into(iconImageView);


        if(listViewItem.getName().contains("천안") || listViewItem.getName().contains("공주")){
            String mTitle=listViewItem.getName();
            mTitle="["+mTitle.substring(0,2)+"]"+mTitle.substring(2);
            TitleTextView.setText(mTitle);
        }
        else {
            if(listViewItem.getAddress().contains("충청남도")){
                String mTitle=listViewItem.getAddress().substring(5,7);
                mTitle="["+mTitle+"]";
                TitleTextView.setText(mTitle+listViewItem.getName());
            }
            else if(listViewItem.getAddress().contains("충남")){
                String mTitle=listViewItem.getAddress().substring(3,5);
                mTitle="["+mTitle+"]";
                TitleTextView.setText(mTitle+listViewItem.getName());
            }
        }
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context, TripExp3Activity.class);
                i.putExtra("Exp3title",listViewItem.getName());
                Log.d("seo-Adapter3->exp3",listViewItem.getName());
                context.startActivity(i);
            }
        });
        return convertView;
    }
    public void addVO(String ListNum, String title, String Address,String ImageUrl) {
        Tab3ItemVO item = new Tab3ItemVO();
        item.setListNum(ListNum);
        item.setName(title);
        item.setAddress(Address);
        item.setImageUrl(ImageUrl);
        list.add(item);
    }


}
