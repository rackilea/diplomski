public static void main(String[] args) throws Exception {
    final HazelcastInstance hz = Hazelcast.newHazelcastInstance(null);
    final IMap map = hz.getMap("test");
    map.put(1, new MyObj(1, new AnotherObject("value")));

    System.out.println(map.values(new SqlPredicate("something > 0 and complexMember.someString like 'val%'")));
}

static class MyObj implements Serializable {
    private int something;
    private AnotherObject complexMember;

    MyObj(final int something, final AnotherObject complexMember) {
        this.something = something;
        this.complexMember = complexMember;
    }
}

static class AnotherObject implements Serializable  {
    private String someString;

    AnotherObject(final String someString) {
        this.someString = someString;
    }
}