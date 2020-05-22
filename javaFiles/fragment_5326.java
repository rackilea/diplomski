StringBuilder sb = new StringBuilder();
for(int i = 0; i < howmany; i++){
   sb.append('%').append(param);
}
sb.append('%');

String query = "some query text where " + sb.toString()