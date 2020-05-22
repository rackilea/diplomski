int total = 0;
int changes[] = new int[str.length()];
for(int i = 1; i < changes.length; i++) {
    if(str.charAt(i) != str.charAt(i - 1)) {
        total++;
    }
    changes[i] = total;
}