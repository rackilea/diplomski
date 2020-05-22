if (mes.myMessage()){

      messageHolder.myTxt.setText(mes.toString());
      messageHolder.hisTxt.setText("");

} else {

      messageHolder.myTxt.setText("");
      messageHolder.hisTxt.setText(mes.toString());
}