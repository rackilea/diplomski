public class MyReceiver {

DataBaseHelper myDB;

public MyReceiver(){


}

public void setData(String incomingNumber, Context context){


    myDB = new DataBaseHelper(context);//i think here i get that error
    Toast.makeText(context, incomingNumber, Toast.LENGTH_LONG).show();
    save(incomingNumber,context);

}


public  void save(String number,Context context){

    if(number!=null){
        AddData(number, context);

    }

}

public void AddData(String number, Context context) {

  boolean isInserted = myDB.insertData(number);

    if(isInserted == true)
        Toast.makeText(context, "Data Inserted", Toast.LENGTH_LONG).show();

    else
        Toast.makeText(context,"Data not Inserted", Toast.LENGTH_LONG).show();
} }