String inputString = "abc123de45";
int n = 2;

StringBuilder buf = new StringBuilder ();

for (int i = 0; i < inputString.length(); i++) {

    char tempInp = inputString.charAt(i);

    if (Character.isDigit(tempInp)) {
        buf.append ((tempInp -'0') + n);
    }
    else {
        buf.append(tempInp);
    }   
}

System.out.println(buf.toString());