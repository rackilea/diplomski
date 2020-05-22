public void writeMethods(DataOutputStream d) throws IOException {
   //do something
}

@Override
public void writeMethods(DataOutput d) throws IOException {
     if(d instanceof DataOutputStream)
          writeMethods((DataOutputStream) d)
     else
          ....  // something else

}