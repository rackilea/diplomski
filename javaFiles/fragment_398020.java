//The old code
Intent intent = getIntent();

 mCurrentPetUri = intent.getData();

        if (mCurrentPetUri == null) {
            setTitle(getString(R.string.editor_activity_title_new_pet));

        } else {
            setTitle(getString(R.string.editor_activity_title_edit_pet));
        }
getLoaderManager().initLoader(1, null, this);