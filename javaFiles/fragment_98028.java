Map<String, List<Integer>> ml;
Map<String, List<?>> ml3 = ml; 

ml3.put("strings", Arrays.asList("evil","string"));

List<Integer> l = ml.get("strings"); //see how this is going to fail?