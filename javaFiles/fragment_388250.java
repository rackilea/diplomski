System.out.println("+-------+-------+");
System.out.println("| number| occurs|");
for (int i = 0; i < arry.size(); i++) {
    if (arry.get(i) > 0) {
        System.out.println("+-------+-------+");
        System.out.println(String.format("|%7d|%7d|", i,arry.get(i)));
    }
}
System.out.println("+-------+-------+");