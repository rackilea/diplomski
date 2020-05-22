private static class YourObject {

     private List<List<String>> myStrings = new ArrayList<>();

    public YourObject() {
        List<String> a = Arrays.asList("a","b","c");
        List<String> b = Arrays.asList("d","f","g");
        myStrings.add(a);
        myStrings.add(b);
}

    @JsonSerialize(using = ListListSerializer.class)
    public Object getMyStrings(){
       return myStrings;
    }
}


public static void main(String[] args) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    System.out.println(mapper.writeValueAsString(new YourObject()));
}