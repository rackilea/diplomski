Pattern pattern = 
Pattern.compile("\\[  [0-6]\\]  (0.0- 1.0 sec)  0.00 KBytes  ([0-9]*.[0-9][0-9] Kbits/sec)");
Matcher matcher = pattern.matcher(lineString);
if(matcher .matches()){
   //....
}