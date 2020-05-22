public static void main(String[] args) {
    System.out.println(getCount("attack at noon"));
}

String getCount(String str) {
        String R = "";
        String S = str;
        int l = S.length();
        int cnt;

        first:for (int i = 0; i < l; i++) { //Foreach letter
            cnt = 0;
            for (int j = i; j < l; j++) {

                if (S.charAt(j) == S.charAt(i)) {

                    if ( R.indexOf(S.charAt(j)) != -1 ) {
                        continue first;
                    }
                    cnt++;
                }
            }
            R = R + S.charAt(i) + cnt; 
        }
        return R;
    }