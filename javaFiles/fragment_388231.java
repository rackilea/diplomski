@Test
  public void theArrayIsInDescendingOrder() throws Exception
  {
    List<Integer> orderedList = new ArrayList<Integer>();
    orderedList.add(10);
    orderedList.add(5);
    orderedList.add(1);
    assertThat(orderedList, isInDescendingOrdering());
  }

  private Matcher<? super List<Integer>> isInDescendingOrdering()
  {
    return new TypeSafeMatcher<List<Integer>>()
    {
      @Override
      public void describeTo (Description description)
      {
        description.appendText("describe the error has you like more");
      }

      @Override
      protected boolean matchesSafely (List<Integer> item)
      {
        for(int i = 0 ; i < item.size() -1; i++) {
          if(item.get(i) <= item.get(i+1)) return false;
        }
        return true;
      }
    };
  }