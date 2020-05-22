@Override
    public ActionMode startActionMode(ActionMode.Callback callback) {
        if (enableWebviewActionmodeInline) {
            // custom actionmode enabled
            Log.i(TAG, "startActionMode() enableWebviewActionmodeInline");
            return super.startActionMode(new MyActionmodeCallback(mainActivity, this, editLayout, editText));
        }

        if (enableWebviewActionmodeActionbar) {
            // custom actionmode enabled
            Log.i(TAG, "startActionMode() enableWebviewActionmodeActionbar");
            return super.startActionMode(new MyActionmodeCallback(mainActivity, this, editLayout, editText));
        }

        // default
        Log.i(TAG, "startActionMode() default");
        return super.startActionMode(callback);
    }

    @Override
    public ActionMode startActionMode(ActionMode.Callback callback, int type) {
        if (enableWebviewActionmodeInline) {
            // custom actionmode enabled
            Log.i(TAG, "startActionMode()_type enableWebviewActionmodeInline");
            return super.startActionMode(new MyActionmodeCallback(mainActivity, this, editLayout, editText), type);
        }

        if (enableWebviewActionmodeActionbar) {
            // custom actionmode enabled
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                Log.i(TAG, "startActionMode()_type enableWebviewActionmodeActionbar Build.VERSION_CODES.M");
                return super.startActionMode(new MyActionmodeCallback(mainActivity, this, editLayout, editText), TYPE_PRIMARY);
            } else {
                Log.i(TAG, "startActionMode()_type enableWebviewActionmodeActionbar");
                return super.startActionMode(new MyActionmodeCallback(mainActivity, this, editLayout, editText));
            }
        }

        // default
        Log.i(TAG, "startActionMode()_type default");
        return super.startActionMode(callback, type);
    }