for(int i=0;i<arr_quesid.size();i++)
     {      

            jobj_id=new JSONObejct(); // 
            jobj_id.put("ques_id", arr_quesid.get(i));
            qhis_jar.put(jobj_id);
            jobj_ans=new JSONObejct();
            jobj_ans.put("ans", arr_ans.get(i));
            qhis_jar.put(jobj_ans);
     }