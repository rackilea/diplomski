public class MyCustomViewAction implements ViewAction {
        int size = 0;

        @Override
        public Matcher<View> getConstraints(){
            return isAssignableFrom(MaterialSearchView.class);
        }

        @Override
        public String getDescription(){
            return "whatever, size = " + size;
        }

        @Override
        public void perform(UiController uiController, View view){
            MaterialSearchView yourCustomView = (MaterialSearchView) view;
            size = yourCustomView.getSuggestionsCount();
            yourCustomView.mSuggestionsListView.performItemClick(yourCustomView.mSuggestionsListView.getAdapter().getView(i, null, null), i, yourCustomView.mSuggestionsListView.getAdapter().getItemId(i));
            Log.e(Constants.TAG_CategoriesActivity, " size = " + size);
        }
    }