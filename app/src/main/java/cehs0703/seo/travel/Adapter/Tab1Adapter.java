package cehs0703.seo.travel.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import cehs0703.seo.travel.Activity.TripExp1Activity;
import cehs0703.seo.travel.ListVO.Tab1ItemVO;
import cehs0703.seo.travel.R;

public class Tab1Adapter extends BaseAdapter {

    ArrayList<Tab1ItemVO> list=new ArrayList<>();

    public Tab1Adapter(ArrayList<Tab1ItemVO> list) {
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.fragment_tab1_list, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        ImageView iconImageView = (ImageView) convertView.findViewById(R.id.Tab_Image1) ;
        TextView titleTextView = (TextView) convertView.findViewById(R.id.TabFrag_Text1) ;
        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득


        Tab1ItemVO listViewItem = list.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        // iconImageView.setImageDrawable(listViewItem.getImg());
        Glide.with(context).load(list.get(position).getImg()).into(iconImageView);
        titleTextView.setText(listViewItem.getName());


        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context, TripExp1Activity.class);
                i.putExtra("list-index",position);

                context.startActivity(i);
            }
        });
        return convertView;
    }
    public void addVO(String icon, String title) {
        Tab1ItemVO item = new Tab1ItemVO();
        item.setImg(icon);
        item.setName(title);
        list.add(item);
    }
}
