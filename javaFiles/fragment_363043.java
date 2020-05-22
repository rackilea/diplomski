final List<Integer> readList = new ArrayList<>();
// ... Fill readList with answers

Answer answerFromList = new Answer() {
    Object answer(InvocationOnMock invocation) {
        // Remove and return first element
        return readList.remove(0);
    }
}

when(reader.readInt()).thenAnswer(answerFromList);
when(reader.readShort()).thenAnswer(answerFromList);