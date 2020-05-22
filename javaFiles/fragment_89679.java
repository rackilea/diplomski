//get all keys as list
List<String> list = new ArrayList<String>(lines.keySet());

//one iteration of this loop deals with 4 keys and 4 values.
for(i=0; i<n; i=i+4) {
    k1 = list.get(i);
    v1 = lines.get(k1);

    k2 = list.get(i+1);
    v2 = lines.get(k2);

    k3 = list.get(i+2);
    v3 = lines.get(k3);

    k4 = list.get(i+3);
    v4 = lines.get(k4);
}