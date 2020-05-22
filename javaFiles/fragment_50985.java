@Mock
private Item item1;
@Mock
private Item item2;

@Test
public void mockCollection() throws Exception {
    when(items.get(0)).thenReturn(item1);
    when(items.get(1)).thenReturn(item2);
    when(item1.getId()).thenReturn(1);
    when(item2.getId()).thenReturn(2);
}