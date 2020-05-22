@Test
public void testChangeEmail()
{
    assertEquals("001", teacher.getEmail());
    teacher.changeEmail("002")
    assertEquals("002", teacher.getEmail());

}