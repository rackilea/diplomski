@TestFor(MyTagLib)
class MyTagLibTests  {
    void testMyTagLib() {
        def templateOut = applyTemplate('<myTags:something date="${date}"/>', [date: new Date(12, 3, 20, 8, 0)])
        assertEquals('08:00', templateOut)
    }
}