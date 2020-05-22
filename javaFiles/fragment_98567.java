public void testing(){
        HashMap<String, List<Cheese>> one = new HashMap<>();
        List<Cheese> two = new ArrayList<>();

        Cheese seven = new Cheese("59");
        Cheese eight = new Cheese("60");
        Cheese nine = new Cheese("12");
        Cheese ten = new Cheese("15");

        two.add(seven);
        two.add(eight);
        two.add(nine);
        two.add(ten);

        System.out.println(two);
        assert "59".equals(two.get(0).num);
        assert "60".equals(two.get(1).num);
        assert "12".equals(two.get(2).num);
        assert "15".equals(two.get(3).num);

        Collections.sort(two);

        System.out.println(two);
        assert "12".equals(two.get(0).num);
        assert "15".equals(two.get(1).num);
        assert "59".equals(two.get(2).num);
        assert "60".equals(two.get(3).num);
        one.put("hello", two);
}