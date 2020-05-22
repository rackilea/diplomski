chk4.setOnCheckedChangeListener(new OnCheckedChangeListener() {

    @Override
    public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {
        // TODO Auto-generated method stub
        if(chk1.isChecked())
        {
            flag=4;
            m[increment]=flag;
            increment++;
            count++;        
        }
        else
        {   
            increment--;
            count--;
        }
    }});