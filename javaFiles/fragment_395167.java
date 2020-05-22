String binary = "11111111";
int number = 0;

for(int i = binary.length() - 1; i >= 0; i--) {
    char c = binary.charAt(i);

    number += Integer.parseInt(c + "") * Math.pow(2, binary.length() - i - 1);
}

System.out.println(number); // prints 255