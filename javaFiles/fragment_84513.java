@Test
public void testPeelingOffItemsFromStream() {

    Stream<Integer> infiniteStream = Stream.iterate(0, x -> x + 1);

    PeelingStream<Integer> peelingInfiniteStream = new PeelingStream<>(infiniteStream);

    Integer one = peelingInfiniteStream.getNext();
    assertThat(one, equalTo(0));

    Integer two = peelingInfiniteStream.getNext();
    assertThat(two, equalTo(1));

    Stream<Integer> limitedStream = peelingInfiniteStream.limit(3); // 2 3 4
    int sumOf234 = limitedStream.mapToInt(x -> x.intValue()).sum();
    assertThat(sumOf234, equalTo(2 + 3 + 4));

}