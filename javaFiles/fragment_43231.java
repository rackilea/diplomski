int max = Integer.MIN_VALUE;
int maxKey = -1;
for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
    if (max < entry.getValue()) {
        max = entry.getValue();
        maxKey = entry.getKey();
    }
}

System.out.println(maxKey + "appears most often: " + max + " times");