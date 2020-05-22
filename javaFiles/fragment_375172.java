String number = "19216801";
int l = number.length() - 3;
for(int a = 0; a < l; a++) {
    for(int b = 0; b < l-a; b++){
        for(int c = 0; c <l-a-b; c++){
            StringBuilder sb = new StringBuilder(number);
            sb.insert(a+1, ".");
            sb.insert(a+b+3, ".");
            sb.insert(a+b+c+5, ".");
            System.out.println(sb);
        }
    }
}