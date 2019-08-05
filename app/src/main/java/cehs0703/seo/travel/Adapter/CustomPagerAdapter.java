package cehs0703.seo.travel.Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

import cehs0703.seo.travel.R;

public class CustomPagerAdapter extends PagerAdapter {

    private static final String TAG = "ImageViewPage";
    Context mContext;
    LayoutInflater mLayoutInflater;
    String[] mResources;

    public CustomPagerAdapter(Context context, String[] resources) {
        mContext = context;
        mResources = resources;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mResources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Log.d(TAG,
                "instantiateItem() called with: " + "container = [" + container + "], position = [" + position + "]");

        View itemView = mLayoutInflater.inflate(R.layout.pager_item, container, false);

        Log.d(TAG, "load in gallery:" + mResources[position] + "#end");
        final ImageView ivPhoto = (ImageView) itemView.findViewById(R.id.iv_photo);

        if (!mResources[position].equals("")){
            Glide.with(mContext)
                    .load(mResources[position].trim())
                    .into(ivPhoto);
        }
        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        Log.d(TAG, "destroyItem() called with: " + "container = [" + container + "], position = [" + position
                + "], object = [" + object + "]");
        container.removeView((LinearLayout) object);
    }
}