public static void main(String[] args) {
        // TODO Auto-generated method stub
        String str = "abcdaa";
        dups(str);
    }

    public static void dups(String str) {
        HashSet<Character> hs = new HashSet<Character>();
        char[] ch = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ch.length; i++) {
            if(hs.add(ch[i])){
                sb.append(ch[i]);
            }
        }
        System.out.println(sb);
    }