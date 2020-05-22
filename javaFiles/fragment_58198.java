public static class AppListFragment extends ListFragment implements
      LoaderManager.LoaderCallbacks<List<SampleItem>> {

  public Loader<List<SampleItem>> onCreateLoader(int id, Bundle args) { 
     //...
     return new SampleLoader (getActivity());
  }

  public void onLoadFinished(Loader<List<SampleItem>> loader, List<SampleItem> data) {
    // ... 
     mAdapter.setData(data);

     if (isResumed()) {
       setListShown(true);
     } else {
       setListShownNoAnimation(true);
     }
    // ... 
 }

  public void onLoaderReset(Loader<List<SampleItem>> loader) { 
    // ... 
    mAdapter.setData(null);
    // ... 
  }

  /* ... */
}