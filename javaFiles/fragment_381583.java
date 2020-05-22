List<Fixture> fixtures = body.getFixtureList();
Iterator<Fixture> i = fixtures.iterator();
while(i.hasNext()) {
    Fixture fixture = i.next();
    if (destroyFixture(fixture)) {
        i.remove();
    }
}