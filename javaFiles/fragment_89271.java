@Test
public void twoWayTransform() {
    Gson gson = new GsonBuilder().serializeNulls().create();

    List<RankAPI> incomings = Arrays.asList(new RankAPI(), new RankAPI());

    String json = gson.toJson(incomings);

    // use TypeToken to inform Gson about the type of the elements in the generic list
    List<RankAPI> fromJson = gson.fromJson(json, new TypeToken<ArrayList<RankAPI>>(){}.getType());

    assertEquals(2, fromJson.size());
    for (RankAPI incoming : incomings) {
        // this will pass if RankAPI has an equals() method
        assertTrue(fromJson.contains(incoming));
    }
}