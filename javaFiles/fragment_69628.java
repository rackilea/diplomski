String s = "1000";
Vector myVec = new Vector();

//Convert the string to a char array and then just add each char to the vector
char[] sChars = s.toCharArray();
for(int i = 0; i < s.length(); ++i) {
    myVec.add(sChars[i]);
}