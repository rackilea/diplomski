import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;

@Test
public void testClickInsertItem() {
    openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
    onView(withId(R.id.action_insert)).perform(click());
}