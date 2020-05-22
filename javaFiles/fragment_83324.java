@Test
    public void TestSuggestions1(){
        for (int i=0 ; i<4081; i++) {

            onView(withId(R.id.action_search)).perform(click());    // opens the search
            Espresso.pressBack();   // performs the go back action to dismiss the keyboard
            onData(anything())      // selects the actual item at the desired position (which opens another activity)
                    .atPosition(i)
                    .perform(click());
            Espresso.pressBack();   // performs the go back action from the newer activity
            Log.e("TestSuggestions", " i = " + i);
        }
    }