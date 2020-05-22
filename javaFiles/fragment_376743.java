public void firstRadioButtons (View view){
    boolean checked = ((RadioButton) view).isChecked();
    int count=0;
    switch (view.getId()) {
        case R.id.questionOneA:
            if (checked)
                {
            if(count!=0){
                points-=5;
                count=0;
                }
                }
                break;
        case R.id.questionOneB:
            if (checked)
                {
            if(count!=0){
                points-=5;
                count=0;
                }
                }
                break;
        case R.id.questionOneC:
            if (checked){
                points += 5;
                count+=1;}
                break;
        case R.id.questionOneD:
            if (checked)
                {
            if(count!=0){
                points-=5;
                count=0;
                }
                }
                break;
    }

}