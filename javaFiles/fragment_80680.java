package com.teamagam.dailyselfie;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

class PictureAdapter extends RecyclerView.Adapter<PictureAdapter.PictureViewHolder> {
    private LayoutInflater mInflater;
    private List<PictureInfo> mPictureInfoList;

    PictureAdapter(Context context, List<PictureInfo> pictureInfoList) {
        mInflater = LayoutInflater.from(context);
        mPictureInfoList = pictureInfoList;
    }

    @Override
    public PictureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.layout_picture, parent, false);
        return new PictureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PictureViewHolder pictureViewHolder, int position) {
        PictureInfo pictureInfo = mPictureInfoList.get(position);
        pictureViewHolder.mTextView.setText(pictureInfo.fileName);
        int imageSize = pictureViewHolder.mImageView
                .getContext()
                .getApplicationContext()
                .getResources()
                .getInteger(R.integer.activity_main_thumbnail_size);
        if (null != pictureViewHolder.mLoadPictureTask) {
            pictureViewHolder.mLoadPictureTask.cancel(true);
        }
        pictureViewHolder.mImageView.setVisibility(View.INVISIBLE);
        pictureViewHolder.mLoadPictureTask = new LoadPictureTask(pictureViewHolder.mImageView, imageSize);
        pictureViewHolder.mLoadPictureTask.execute(pictureInfo.path);
    }

    @Override
    public int getItemCount() {
        return mPictureInfoList.size();
    }

    class PictureViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;
        TextView mTextView;
        LoadPictureTask mLoadPictureTask;

        PictureViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.ivItemListImage);
            mTextView = (TextView) itemView.findViewById(R.id.tvItemListImage);
        }
    }
}