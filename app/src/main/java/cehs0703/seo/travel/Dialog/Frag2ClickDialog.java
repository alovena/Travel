package cehs0703.seo.travel.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


import cehs0703.seo.travel.R;

public class Frag2ClickDialog extends Dialog {
    String mUrl="";
    String mDesc="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag2_click_dialog);
        //화면밖 흐리게!
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        layoutParams.dimAmount = 0.8f;
        getWindow().setAttributes(layoutParams);
        ImageView imageView=(ImageView)findViewById(R.id.Dialog2Image);
        TextView textView=(TextView)findViewById(R.id.DialogText);

        Glide.with(getContext()).load(mUrl).into(imageView);
        textView.setText(mDesc);

    }
    public Frag2ClickDialog(Context context, String mUrl, String desc) {
        super(context);
        this.mUrl=mUrl;
        this.mDesc=desc;
    }



}
