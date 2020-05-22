ArrayList<HashMap<String, String>> test = new ArrayList<HashMap<String, String>>();
HashMap<String, String> n = new HashMap<String, String>();
n.put("a", "a");
n.put("b", "b");
test.add(n);

HashMap<String, String> m = test.get(0);//it will get the first HashMap Stored in array list 

String strArr[] = new String[m.size()];
int i = 0;
for (HashMap<String, String> hash : test) {
    for (String current : hash.values()) {
        strArr[i] = current;
        i++;
    }
}