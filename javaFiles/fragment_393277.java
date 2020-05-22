private final List<Type_General> mDataset = new ArrayList<>();

    SuggestionsAdapter(List<? extends Type_General> myDataset, EditProfileFragment.SuggestionsEditTextEnum editTextEnum,
                       EditText editText, RecyclerView recyclerView) {
        mDataset.addAll(myDataset);
    }