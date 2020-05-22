public static class Entity {

    public List<SubEntity> subEntities;
}

public static class SubEntityA implements SubEntity {

}

public static class SubEntityB implements SubEntity {

}

private List<? extends SubEntity> getMocks(Class<? extends SubEntity> classToMock, int amount) {
    List<SubEntity> mocks = new ArrayList<>();
    for (int i = 0; i < amount; i++) {
        mocks.add(mock(classToMock));
    }
    return mocks;
}

@Test
public void test(){
    assertEquals(3, getMocks(SubEntityA.class, 3).size());
    List<SubEntityA> mocks = (List<SubEntityA>) getMocks(SubEntityA.class, 3);
    assertEquals(3, getMocks(SubEntityB.class, 3).size());
}