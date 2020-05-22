from_adapter=new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_spinner_item, title);
from_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            title2.clear();
            from_adapter2=new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_spinner_item, title2);
            from_adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spinner.setAdapter(from_adapter);
    //from_adapter2.clear();
    //from_adapter2.notifyDataSetChanged();
    spinner2.setAdapter(from_adapter2);