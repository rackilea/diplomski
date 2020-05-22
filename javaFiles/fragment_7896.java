Scanner x = new Scanner(System.in);
int t = x.nextInt();
String p[] = new String[n];

for (int j = 0; j < t; j++) {
    p[j] = x.nextLine();
}

for (j = 0; j < p.length(); j++) {
    for(k = 1; k < p.length(); k++) {
        if (p[j] = reverse(p[k])) {
            int q = p[k].length();
            System.out.println(""+q+((q/2)+1));
        }