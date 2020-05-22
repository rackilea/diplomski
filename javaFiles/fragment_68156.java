public static void main(String[] args) {
            String[] stringArray=new String[]{"Hello/World","Hello/12","15/Hello","12/17"}; 
            for(String s:stringArray) {
                System.out.println(s.replaceAll("(([a-zA-Z]+?)/([a-zA-Z]+))|(([a-zA-Z]+?)/([\\d]+))|(([\\d]+?)/([a-zA-Z]+))", "$2$5$8,$3$6$9"));
            }
        }