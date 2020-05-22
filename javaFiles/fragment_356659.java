for (int i = 0 ; i < data_array.length() ; i++)
        {
            JSONObject obj=new JSONObject(data_array.get(i).toString());
            String[] nameArray;
            String[] distArray;
            String[] latArray;
            nameArray[i] = (data_array.getJSONObject(i).getString("rtrname"));
            distArray[i] = (data_array.getJSONObject(i).getString("ctgname"));
            latArray[i] = (data_array.getJSONObject(i).getString("rtrphone"));
            //lonArray[i] = (data_array.getJSONObject(i).getString("longitude"));

            db.insert(nameArray[i],distArray[i],latArray[i]);

        }