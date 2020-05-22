str2 = #19, 6th cross, 7th main road, townname, cityname-560036
str3 = #19, 6th cross, 17th main road, townname, cityname-560036

String[] s2 = str2.split(",");
String[] s3 = str3.split(",");

for (int i = 0; i < s2.length; i++) {
    al.add(s2[i]);
}

for (int i = 0; i < s3.length; i++) {
    al1.add(s2[i]);
}

al.retainAll(al1);

System.out.println("Size of a1 is " + a1.size());