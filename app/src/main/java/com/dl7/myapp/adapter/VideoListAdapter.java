package com.dl7.myapp.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.dl7.myapp.R;
import com.dl7.myapp.local.table.VideoBean;
import com.dl7.myapp.module.video.player.VideoPlayerActivity;
import com.dl7.myapp.utils.DefIconFactory;
import com.dl7.myapp.utils.ImageLoader;
import com.dl7.recycler.adapter.BaseQuickAdapter;
import com.dl7.recycler.adapter.BaseViewHolder;

import java.util.List;

/**
 * Created by long on 2016/10/11.
 */

public class VideoListAdapter extends BaseQuickAdapter<VideoBean> {

    public VideoListAdapter(Context context) {
        super(context);
    }

    public VideoListAdapter(Context context, List<VideoBean> data) {
        super(context, data);
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.adapter_video_list;
    }

    @Override
    protected void convert(final BaseViewHolder holder, final VideoBean item) {
        final ImageView ivPhoto = holder.getView(R.id.iv_photo);
        ImageLoader.loadFitCenter(mContext, item.getCover(), ivPhoto, DefIconFactory.provideIcon());
        holder.setText(R.id.tv_title, item.getTitle());
        holder.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VideoPlayerActivity.launch(mContext, item);
            }
        });
    }

}
