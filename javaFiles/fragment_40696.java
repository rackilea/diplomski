message = getIntent().getStringExtra(IntentConstants.INTENT_MESSAGE_DATA);
 if (fragment == null){
    editTodoFragment = new EditTodoFragment();
    // 
    Bundle bundle = new Bundle();
    bundle.putInt(key, message);
    fragment.setArguments(bundle);

    fm.beginTransaction()
            .add(R.id.contentFrameContainer, editTodoFragment)
            .commit();
    editTodoPresenter = new EditTodoPresenter(editTodoFragment);
 }