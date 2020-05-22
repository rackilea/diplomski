private boolean assertSameObjects(List<?> list1, List<?> list2) {
    assertEquals(list1.size(), list2.size());
    for (int i = 0; i < list1.size(); i++) {
        assertSame(list1.get(i), list2.get(i));
    }
}