setMyTime(EditText editText,String date1, String date2){
   SimpleDateFormat format = new SimpleDateFormat("HH:mm");
   try {
             Date d1 = format.parse(date1);
             Date d2 = format.parse(date2);
            long difference = d1.getTime() - d2.getTime();
            int minutes = (int) ((difference / (1000 * 60)) % 60);
            int hours = (int) ((difference / (1000 * 60 * 60)) % 24) - 1;
            editText.setText((hours + ":" + minutes));
        }catch (Exception e) {

            System.err.println(e.printStackTrace());
        }
}