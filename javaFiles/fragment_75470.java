@Override
    public void onSelectDate(Date date, View view) {


        if(DatesList.contains(date)){
            myDB = CustomApplication.getDatabaseHelper();

            final DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

            String printedData = df.format(date.getTime());


            int dateID = myDB.getDateId(printedData);
            Log.d(Tag,""+dateID);
            String returnedData = myDB.getDates(dateID);

            Intent i = new Intent(getContext(),TesteInfoDisplay.class);



            startActivity(i);
        }
        else{
            Toast.makeText(getContext(),"Não tem nenhum teste nesse dia.",Toast.LENGTH_LONG).show();
        }

    }
};