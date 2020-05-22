CaseComment[] list = form.getCaseDataJaxb().getCommentList();
JSONObject obj = new JSONObject();
JSONArray comments = new JSONArray();
JSONObject obj = new JSONObject();
    JSONArray comments = new JSONArray();
    String str = list[i].getText());
    str = str.replaceAll("<","&amp;");  
    commObj.put(str);
    comments.put(commObj);
    }
}
obj.put("comData", comments);
response.setContentType("text/json");
response.getWriter().write(obj.toString());