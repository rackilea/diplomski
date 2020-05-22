public void
test_can_index_from_database() {
    // create your index from database

    assertThat(myIndex, containsWord('expected_word_in_index'));
}