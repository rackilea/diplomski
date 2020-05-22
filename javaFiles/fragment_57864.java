StringBuilder sOdd = new StringBuilder("");
StringBuilder sEven = new StringBuilder("");

while (numb <= 100) {
    if (numb % 2 == 0) {
        sEven.append(numb).append(",");
    }
    if (numb % 2 != 0) {
        sOdd.append(numb).append(",");
    }
   numb++;
}

System.out.println(sEven.toString()+"\n"+sOdd.toString());