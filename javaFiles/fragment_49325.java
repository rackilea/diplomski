@Test 
public void knightShouldEmbarkOnQuest() { 
    Quest mockQuest = mock(Quest.class); 
    Mockito.doThrow(RuntimeException.class).when(mockQuest).embark();
    ...
}