if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1) {
   char[] array = content[1].toCharArray();   /*content[1] is a string containing the original version */
   for(int i=0; i<array.length; i++){
        char c = array[i];
        int code = (int) c;
        if (code == 2367){    //2367 is int value for 'raswa'
            char temp = array[i-1];
            array[i-1]=c;
            array[i]=temp;
        }
    }
    String str = String.copyValueOf(array); /*This string contains the swapped version(symantically its wrong, though. It's works as my solution.)*/
    Log.d("DetailActivity", "from gingerbread");
    Log.d("DetailActivity", str);
    if(!content[1].equals(null))txtviewdevanagari.setText(str);
}else{
    Log.d("DetailActivity", "from ICS+");
    if(!content[1].equals(null))txtviewdevanagari.setText(content[1]);
}