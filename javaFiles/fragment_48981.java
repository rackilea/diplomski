for(int i=0;i<arrSize;i++) {
            object = prestationlist.getJSONObject(i);
            value.add(object.getString("Value"));
            name.add(object.getString("Text"));
            //Here i've made some display to see if it works, i get the data.
           yourarraylist.add(object.getString("Text"));
            responseView.setText(value.toString());
        }
       adapter1.notifyDataSetChanged();