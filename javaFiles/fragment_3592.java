location[0][0] = createArea("You are in the upper left\n");
location[1][0] = createArea("You are in the upper middle\n");



HashMap <String, String> createArea(String desc){
    HashMap <String, String> area = new HashMap <String, String> ();
    area.put("description", desc);
    return area;
}