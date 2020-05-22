public static String mutation(String s,String t){
 int f=s.indexOf("fzgh");
 int l =4;//length of "fzgh" 
 String w = s;
 while(f!=-1){
    w=w.substring(0,f)+t+w.substring(f+l,w.length());
    f=w.indexOf("fzgh");
 }
  return w;
}