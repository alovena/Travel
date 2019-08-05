package cehs0703.seo.travel.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import cehs0703.seo.travel.Dialog.Frag2ClickDialog;
import cehs0703.seo.travel.ListVO.Tab2ItemVO;
import cehs0703.seo.travel.R;

public class MyRecyclerAdpater extends RecyclerView.Adapter<MyRecyclerAdpater.ViewHolder> {

    public final ArrayList<Tab2ItemVO> list;
    Activity activity;

    public MyRecyclerAdpater(ArrayList<Tab2ItemVO> list, Activity activity) {
        this.list = list;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_tab2_card,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
            Tab2ItemVO tab2ItemVO=list.get(i);
            viewHolder.titleTextView.setText(tab2ItemVO.getTitle());
        Glide.with(viewHolder.itemView.getContext()).load(tab2ItemVO.getImgUrl()).into(viewHolder.ImageView);


        viewHolder.ImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                AlertDialog.Builder builder=new AlertDialog.Builder(activity);
//                builder.setTitle("충남30미")
//                        .setPositiveButton("확인",null)
//                        .setView(viewHolder.ImageView);
//                AlertDialog dialog=builder.create();
//                dialog.show();

                // Dialog 사이즈 조절 하기

                Frag2ClickDialog dialog=new Frag2ClickDialog(viewHolder.itemView.getContext(),list.get(i).getImgUrl(),list.get(i).getDesc());
                dialog.show();


                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                lp.copyFrom(dialog.getWindow().getAttributes());
                lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
                lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
                Window window = dialog.getWindow();
                window.setAttributes(lp);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView titleTextView;
        ImageView ImageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTextView=itemView.findViewById(R.id.TabFrag_Text2);
            ImageView=itemView.findViewById(R.id.Tab_Image2);

        }
    }

    }

