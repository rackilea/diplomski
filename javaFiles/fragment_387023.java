String acl = "x110101";

BitSet bs1 = new BitSet();
for (int i = 1; i < acl.length(); i++)
    if (acl.charAt(i) == '1')
        bs1.set(i);