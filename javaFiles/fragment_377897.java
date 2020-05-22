// Adjust types accordingly
for (Map.Entry<String, String> entry : map.entrySet()) {
    if (entry.getValue().equals(targetValue)) {
        System.out.println(entry.getKey());
    }
}