String[] sorCodes = form.getSorCodes();
if  (sorCodes.length > 1) {
    StringBuilder builder = new StringBuilder("(");
    for( int i=0;i<sorCodes.length;i++) { 
       builder.append("'").append(sorCodes[i]).append("'");
       if(i < sorCodes.length - 1) {
          builder.append(",");
       }
    }
    builder.append(")");

    builder.toString(); //('STRING','STRING') 
}