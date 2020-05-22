@Test
public void canGetAllSkeletons(){
    examRepository = new ExamRepository(entityManager);

    List<ExamSkeleton> expected = new ArrayList<>();
    expected.add(new ExamSkeleton());
    expected.add(new ExamSkeleton());

    TypedQuery query = mock(TypedQuery.class);
    when(entityManager.createQuery(anyString(), anyObject())).thenReturn(query);
    when(query.getResultList()).thenReturn(expected);

    List<ExamSkeleton> result = examRepository.getAllSkeletons();

    assertEquals(expected, result);
}