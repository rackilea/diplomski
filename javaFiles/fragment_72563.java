String[] Splited=stringValue.split("\n");
 String msg="";           
    for(int i=0;i<Splited.length;i++){
       if(Splited[i].startsWith("$"))
          msg=msg+"<b>"+Splited[i]+"</b>";
       else
          msg=msg+Splited[i];

}
textview.setText(Html.fromHtml(msg));