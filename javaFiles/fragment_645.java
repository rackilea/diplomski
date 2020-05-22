package com.test;

import com.opensymphony.xwork2.Action;

public class TestAction implements Action{
    private String simpleParam;

    public String getSimpleParam() {
        return simpleParam;
    }

    public void setSimpleParam(String simpleParam) {
        this.simpleParam = simpleParam;
    }

    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("id", simpleParam);
        return SUCCESS;
    }
}