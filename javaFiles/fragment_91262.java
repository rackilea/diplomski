public WtfArrayAdapter(Context context, @LayoutRes int resource,
      @NonNull T[] objects, MainActivity parent) {
        super(context, resource, 0, Arrays.asList(objects));
        sParent = parent;
        sFilter = new WtfArrayFilter();
        pFilter = super.getFilter();
    }