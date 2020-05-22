@Override
    public void onStart() {
        super.onStart();
        Log.w(TAG, "-------------- onStart");
        if (((MasterTabActivity) getActivity()).getCallDetailsDictionary() != null) {
            refreshData();
        }

    }