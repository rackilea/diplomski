package com.test;

import com.opensymphony.xwork2.Action;

public class HelloAction implements Action {
    private String id;
    private String result;

    public String getId() {
        return id;
    }

    public String getResult() {
        return result;
    }

    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        id = (String)request.getAttribute("id");

        result = "result" + getId();
        return SUCCESS;
    }
}