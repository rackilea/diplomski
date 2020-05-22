package com.example.jsonparser;

import java.util.ArrayList;

public class Data {

    private String mState;
    private String mImageUrl;
    private String mTitle;
    private String mSummary;
    private ArrayList<String> mAddList;
    private String mUrl;

    public Data(String mState, String mImageUrl, String mTitle,
            String mSummary, ArrayList<String> addList, String mUrl) {
        super();
        this.mState = mState;
        this.mImageUrl = mImageUrl;
        this.mTitle = mTitle;
        this.mSummary = mSummary;
        this.mAddList = addList;
        this.mUrl = mUrl;
    }

    public String getmState() {
        return mState;
    }

    public void setmState(String mState) {
        this.mState = mState;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public void setmImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmSummary() {
        return mSummary;
    }

    public void setmSummary(String mSummary) {
        this.mSummary = mSummary;
    }

    public ArrayList<String> getmAddress1() {
        return mAddList;
    }

    public void setmAddress1(ArrayList<String> mAddress1) {
        this.mAddList = mAddress1;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }

}