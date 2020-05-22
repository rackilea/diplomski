for (int z = 0; z < memberships.size(); z++) {
    JSONObject m = (JSONObject) memberships.get(z);
    JSONObject innerObj = (JSONObject) m.get("project");

    // If you want section
    String section = (String) m.get("section");
    System.out.println("section " + section);


    Long id = (Long) innerObj.get("id");
    String name = (String) innerObj.get("name");
    System.out.println("id " + id + " with name " + name);

}