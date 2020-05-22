buttonsubmit.setOnClickListener(new OnClickListener() {

    @Override
    public void onClick(View v) {

        if(from.before(to)){

            boolean alreadyExists = false;
            for(int j = 0; j < myList.size(); j ++){ 

                Calendar dateFrom = myList.get(j).dateFrom;
                Calendar dateTo = myList.get(j).dateTo;

                if(isSameDay(from, dateFrom) && isSameDay(to, dateTo)){ // checking same period allready exists
                    alreadyExists = true;
                    break;
                }
            }
            if (alreadyExists){
                Toast.makeText(getApplicationContext(),
                            "Already exist",
                            Toast.LENGTH_LONG).show();
            }
            else{
                myList.add(new DateClassObject(from, to));
            }
        }
        tvfrompick.setText("");
        tvtopick.setText("");
    }
});