@Test
    public void TestSuggestions2() {
        for (i = 0; i < 4081; i++) {
            onView(withId(R.id.action_search)).perform(click());    // opens the search
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Espresso.pressBack();   // performs the go back action from the newer activity
            onView(withId(R.id.search_view)).perform(new MyCustomViewAction()); // selects the actual item at the desired position (which opens another activity)
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Espresso.pressBack();
        }
    }