public static void main(String[] args) {

        Scanner in =new Scanner(System.in);

        System.out.println("please enter the query string! ");

        String query= in.next();
        System.out.println("please enter the filter stirng!");

        String filter= in.next();
        System.out.println("the query string is : [" + query+ "]");
        System.out.println("the filter string is : [" + filter+ "]");

        QueryResolver resolver = new QueryResolver();
        int count = resolver.where(query).matches(filter).count();

        System.out.println("the characters of the String ["+filter+"] has been found in the forworded string ["+query+"] exactly "+count+" times!" );
        in.close();
    }