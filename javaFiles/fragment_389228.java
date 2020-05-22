String s = "xarxatxm";
int pos = -1;
while (true) {
    pos = s.indexOf('x', pos+1);
    if (pos < 0) break;
    System.out.println(pos);
}