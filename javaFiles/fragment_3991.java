@Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        switch (item.getItemId()){
            case R.id.searchicon:
                // ...
                return true;
            case R.id.listicon:
                 FragmentManager fm = getFragmentManager();
        fm.beginTransaction().replace(R.id.content_frame, new MenuLVFragment()).commit();
                return true;
            case R.id.gridicon:
                // ...
                 FragmentManager fm = getFragmentManager();
        fm.beginTransaction().replace(R.id.content_frame, new MenuGridFragment()).commit();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }