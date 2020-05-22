String[] arr = new String[] {"0001", "0020", "0002", "0003", "0019", "0005", "0007",
                             "0010", "0018", "0011", "0012", "0013", "0014", "0015"};
Map<Integer, String> m = new TreeMap<Integer, String>();
for (String s : arr)
    m.put(new Integer(s), s);
Iterator<Entry<Integer, String>> it;
Integer prev = -1;
StringBuffer sb = new StringBuffer();
boolean isCont = false;
for (it=m.entrySet().iterator(); it.hasNext();) {
    Entry<Integer, String> entry = it.next();
    if (prev == -1)
        sb.append(entry.getValue());
    else if (entry.getKey() == (prev+1))
        isCont = true;
    else if (entry.getKey() > (prev+1)) {
        if (isCont)
            sb.append('-').append(m.get(prev)).append(", ");
        else
            sb.append(", ");
        sb.append(entry.getValue());
        isCont = false;
    }
    prev = entry.getKey();
}
if (isCont)
    sb.append('-').append(m.get(prev));
System.out.println(sb);