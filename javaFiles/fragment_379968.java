int diff = Integer.MAX_VALUE;

for (int i = 0; i < list.size(); i++) {
    if (Math.abs(starting - list.get(i)) < diff) {
        nearest = list.get(i);
        diff = Math.abs(starting - list.get(i));
    }
}

System.out.print("The closest element of the list is " + nearest + ".");