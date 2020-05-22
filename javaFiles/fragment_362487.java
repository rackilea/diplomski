public class BookHourTest {

    @Test
    public void shouldParse() {
        // given
        String time = "10:30";

        // when
        final BookHour bookHour = new BookHour(time);

        // then
        assertEquals(bookHour.getHours(), 10);
        assertEquals(bookHour.getMinutes(), 30);
    }

}