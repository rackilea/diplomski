public static void main (String[] args) throws java.lang.Exception
        {
            String MT="Mike<a anystring>anystring2</a anystring3>Tyson";
            String stripped = MT.replaceAll("<[^*]*>", " ");
            System.out.println(stripped);
        }