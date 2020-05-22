Map<String, String> jsonMap = new HashMap<>();

for (MyImage image : images) {
    jsonMap.put(image.getImageName(), image.getImageBytes());
}
myParameters.put("images", jsonMap);