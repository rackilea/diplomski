public static void main(String[] args) {
        List<String> result = splitKeyToPairs("1234567890");
        List<String> test = new ArrayList<>(Arrays.asList("12", "34", "56", "78", "90"));

        for(int i = 0; i < result.size();++i) {
            if(!result.get(i).equals(test.get(i))) {
                System.out.println("error on position " + i);
            }
        }
    }