public static void main(String[] args) {

        String filter="kjasd";
        String query="kjg4t";


        QueryResolver resolver = new QueryResolver();
        int count = resolver.where(query).matches(filter).count();

        System.out.println(count);
    }