package com.form.response;

import java.util.List;

public class ResponseList {

    public ResponseList(List<Response> responseList) {
           this.responseList=responseList;
        // TODO Auto-generated constructor stub
    }

    private List<Response> responseList;

    public List<Response> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<Response> responseList) {
        this.responseList = responseList;
    }

}