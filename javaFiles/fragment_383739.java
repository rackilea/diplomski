HashMap<String,String> hashMap = new HashMap<String,String>();
String[] string1 = {"5648", "4216", "3254", "2541", "10"};
String[] string2 = {"Derp: 10", "Herp: 3254", "peter: 2541", "jdp: 4216", "dieter: 5648"};
for (String str : string2)
{
    String[] keyVal = str.split(": ");
    hashMap.put(keyVal[1],keyVal[0]);
}
for (String key : string1)
{
    String val = hashMap.get(key);
    System.out.println(val+": "+key);
}