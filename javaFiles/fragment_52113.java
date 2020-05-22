// given: an empty list
List myList = new ArrayList();

// when: we try to get the first element of the list
when(myList).get(1);

// then: we expect an IndexOutOfBoundsException
then(caughtException())
        .isInstanceOf(IndexOutOfBoundsException.class)
        .hasMessage("Index: 1, Size: 0") 
        .hasNoCause();