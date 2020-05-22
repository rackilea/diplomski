//...some code ...
String contents = data.getStringExtra("SCAN_RESULT");
if(contents!=null && contents.length() >= 14){
    String Id = contents.substring(0, 10),
    password = contents.substring(10, 14);
    //    formatTxt.setText("FORMAT: " + contents);
    //  contentTxt.setText("CONTENT: " + format);

    Toast toast = Toast.makeText(getActivity(), "" + contents, Toast.LENGTH_LONG);
    toast.show();
    setdetails(id.toString(), password.toString());   
}else{
    Toast toast = Toast.makeText(getActivity(), "Invalid Data", Toast.LENGTH_LONG);
    toast.show();
}