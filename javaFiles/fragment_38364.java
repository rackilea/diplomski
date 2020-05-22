@Override
public Dialog onCreateDialog(Bundle savedInstanceState) {
// TODO Auto-generated method stub

AlertDialog.Builder theDialog = new AlertDialog.Builder(getActivity());
theDialog.setTitle("About");
String d1 = "Thanks For Downloading! ";
String d2 = "Made by ME";
theDialog.setMessage(d1 +"\n"+ d2 ); 
theDialog.setPositiveButton("My Other Apps", new DialogInterface.OnClickListener(){


@Override
public void onClick(DialogInterface dialog, int which) {
    String url = "http://www.example.com";
    Intent i = new Intent(Intent.ACTION_VIEW);
    i.setData(Uri.parse(url));
    startActivity(i);

}

});

theDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){

@Override
public void onClick(DialogInterface dialog, int which) {
    Toast.makeText(getActivity(), "Clicked Cancel",
    Toast.LENGTH_SHORT).show();

}

});     
return theDialog.create();
}
}