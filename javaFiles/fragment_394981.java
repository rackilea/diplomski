int i =0;
while (str!= null && i < lineNum) {
  names[i] = str;
  str = br1.readLine();
  System.out.println(names[i]);
}