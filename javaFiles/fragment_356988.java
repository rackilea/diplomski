QueryRequest us = new QueryRequest("HierarchicalRequirement");
            us.setFetch(new Fetch("Name", "FormattedID","Tasks"));
            JsonArray us1 = restApi.query(us).getResults();
            for(int i=0;i<us1.size();i++)
            {
                QueryRequest task = new QueryRequest((JsonObject) us1.get(i).getAsJsonObject().get("Tasks"));
                task.setFetch(new Fetch("Name","Actuals","Estimate"));
                JsonArray tsk = restApi.query(task).getResults();
                for(int j=0;j<tsk.size();j++)
                {
                    MyData data = new MyData(us1.get(i).getAsJsonObject().get("Name").toString(),tsk.get(j).getAsJsonObject().get("Name").toString(),tsk.get(j).getAsJsonObject().get("Actuals").toString(),tsk.get(j).getAsJsonObject().get("Estimate").toString());
                    //System.out.println("UserStory : "+us1.get(i).getAsJsonObject().get("Name")+"Task : "+tsk.get(j).getAsJsonObject().get("Name"));
                    data_list.add(data);
                }
            }