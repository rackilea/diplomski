String temp = Integer.toString(number);

int[] num = new int[temp.length()];

for (int i = 0; i < temp.length(); i++){
    num[i] = temp.charAt(i) - '0';
}

for (int i = 0; i < temp.length(); i++) {
    System.out.println(num[i]);
}