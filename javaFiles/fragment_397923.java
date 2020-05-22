if (res1 != null && res1.moveToFirst()) {
  do {
    o.put("mysqlsysid", res.getString(res.getColumnIndex("questionsysid")));
    o.put("questiondisplaynum", res.getString(res.getColumnIndex("question_display_order")));
    o.put("questionorder", res.getString(res.getColumnIndex("question_order")));
    o.put("questioncategory", res.getString(res.getColumnIndex("question_category")));
    o.put("question", res.getString(res.getColumnIndex("question")));
    o.put("status", res.getString(res.getColumnIndex("status")));  
} while (res1.moveToNext());