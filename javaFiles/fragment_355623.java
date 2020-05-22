public static void main(String[] args) {
        String st = "((3-(5-2))+(2*(5-1)))";
        st = st.replaceAll("(5-1)", "4");
        System.out.println(st);
        st = st.replaceAll("(2\\*\\(4\\))", "8");
        System.out.println(st);
    }