ViewInteraction textView = onView(
            allOf(withId(R.id.textView), withText("Rooh"),
                    childAtPosition(
                            childAtPosition(
                                    withId(android.R.id.content),
                                    0),
                            0),
                    isDisplayed()));
    textView.check(matches(withText("Rooh")));