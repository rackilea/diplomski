public static void main( String[] args ) {
    GsonBuilder builder = new GsonBuilder();
    builder.registerTypeAdapter(new TypeToken<A>(){}.getType(), new ATypeAdapter());
    Gson gson = builder.create();

    B b = new B();
    b.foo = "foo";
    b.bar = "bar";

    List<A> list = new ArrayList<A>();
    list.add(b);

    System.out.println(gson.toJson(b, new TypeToken<A>(){}.getType()));
    System.out.println(gson.toJson(b, new TypeToken<B>(){}.getType()));

    System.out.println(gson.toJson(list, new TypeToken<List<A>>(){}.getType()));
    System.out.println(gson.toJson(list, new TypeToken<List<B>>(){}.getType()));
}