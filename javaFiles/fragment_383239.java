@Test
    public void testClipArray() throws Exception {
        // Lets assume our array contains 2 elements
        Clip[] clipArray = new Clip[2];
        clipArray[0] = new Clip("First", "Clip");
        clipArray[1] = new Clip("Second", "Clip");

        // Lets retrieve 2nd object (with index: 1)
        Clip secondObject = clipArray[1];

        System.out.println(secondObject.getAuthor());
        System.out.println(secondObject.getTitle());
    }