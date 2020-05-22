String s = "This is not good";
HashMap<String, String> subjectMap = new HashMap<>();
subjectMap.put("Good", "");
subjectMap.put("Bad", "");
subjectMap.put("Not Good", "");
subjectMap.put("Very Good", "");

for (String str : subjectMap.keySet()) {
    if (s.toLowerCase().contains(str.toLowerCase())) {
        System.out.println(str);
    }
}