Map<String, String> left1 = new HashMap<>(), right1 = new HashMap<>();
left1.put("a", "A");
left1.put("b", "B");
left1.put("c", "C");

right1.put("a", "A");
right1.put("d", "B");

Map<String, String> left2 = new HashMap<>(), right2 = new HashMap<>();
left2.put("a", "AA");
left2.put("b", "BB");
left2.put("c", "CC");

right2.put("a", "AA");
right2.put("d", "BB");

System.out.println(merge(Arrays.asList(left1, left2), 
        Arrays.asList(right1, right2), "a", "a"));