@Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        Log.i(TAG, "onActionItemClicked()");

        // TODO Auto-generated method stub
        switch (item.getItemId()) {
            case R.id.item_edit:
                Log.i(TAG, "onActionItemClicked() R.id.item_option1");
//                editLayout.setVisibility(View.VISIBLE);
                mainActivity.showDialog();
                return true;
        }
        return false;
    }