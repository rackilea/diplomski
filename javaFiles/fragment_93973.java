if (listView != null && listView.getAdapter() != null
     && listView.getChildAt(listView.getChildCount() - 1) != null
     && listView.getLastVisiblePosition() == listView.getAdapter().getCount() - 1
     && listView.getChildAt(listView.getChildCount() - 1).getBottom() <= listView.getHeight()) {
        Toast.makeText(getApplicationContext(), "Bottom!", Toast.LENGTH_LONG).show();
}