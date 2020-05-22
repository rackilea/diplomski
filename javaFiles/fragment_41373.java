public static class Wrapper { /* or whatever you can call it */

    private Response response;
    private Location location;
    ...

}

Wrapper wrapper = gson.fromJson(json, Wrapper.class);