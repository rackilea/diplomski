class Test {
    public static void main(String[] args){

        String test = "'hello',2,[5,6],'city'";
        String[] output = test.split(",(?![^\\[]*[]])");

        for (String s : output)
            System.out.println(s);

    }
}