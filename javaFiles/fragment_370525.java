if(date != null) {
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
        result = df.format(date) + "" + name + "" + Phone ; 
}
else {
      result = name + "" + Phone ; 
}