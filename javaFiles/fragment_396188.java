public static void dups(String str) {
            HashSet<Character> hs = new HashSet<Character>();
            StringBuilder sb = new StringBuilder();
            for (Character character : str.toCharArray()) {
                if(hs.add(character)){
                    sb.append(character);
                }
            }
            System.out.println(sb);
        }