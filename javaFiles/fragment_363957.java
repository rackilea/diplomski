System.out.print("Give a positive odd integer: ");
Scanner s = new Scanner(System.in);
int N = s.nextInt();
int cnt1 = 0;
int line = N - 1;
char c1 = '*';
char c2 = ' ';

if (N > 0 && N % 2 == 1) {
    while (cnt1 < N){
        StringBuilder sb = new StringBuilder(); // CHANGED
        int cnt2 = 0; // CHANGED
        int cnt3 = 0; // CHANGED

        while (cnt2 < N-line){
            while (cnt3 < line){
                sb.append(c2);
                cnt3++;
            }
            sb.append(c1);
            cnt2++;
        }
        line--;
        cnt1++;
        System.out.println(sb.toString());
    }
}