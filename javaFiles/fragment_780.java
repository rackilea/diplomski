int max = Integer.MIN_VALUE; // or max = tInt[0]
for (int i = 0; i < tInt.length; i ++) {
    if (tInt[i] > max) {
       max = tInt[i];
    }
}

System.out.println("Max is: " + max);