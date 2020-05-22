Charset charset = StandardCharsets.ISO_8859_1;
...
    current_user_eid = new String(msg, offset, length, charset);
} 
else
    return;

length = msg[off+1]*256 + msg[off];
offset = msg[off+3]*256 + msg[off+2];
current_user_eid = new String(msg, offset, length, charset);
length = msg[off+9]*256 + msg[off+8];
offset = msg[off+11]*256 + msg[off+10];
current_user_eid = new String(msg, offset, length, charset);
//current system user name "yaseer"

// String Comparison starts here....

String hard_str = "yaseer"; // 

String eid_str = current_user_eid; //passing the fetched username which is yaseer
String eid_str_in = eid_str.intern(); // system username 

String comp_str = "yaseer"; // String for comparison

System.out.println(hard_str_in == comp_str); // give true

System.out.println(eid_str_in == comp_str); // gives false
System.out.println(eid_str_in.equals(comp_str));
// gave true ("on screen"), expected to give false