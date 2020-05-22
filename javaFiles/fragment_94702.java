String[] arr = sentence.Split(" ");
StringBuilder sb = new StringBuilder(); //can specify size for better results possibly

for (String s :arr ){
   if ( dic.contains(s) ){
       sb.append(dic.get(s));
   }else{
       sb.append(s);
   }
}

sb.toString();//your replaced string