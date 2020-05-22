if (view != null) {
    ViewGroup parent = (ViewGroup) view.getParent();
    if (parent != null)
        parent.removeView(view);
}
try {
    view = inflater.inflate(R.layout.map, container, false);
} catch (InflateException e) {
    /* map is already there, just return view as it is */
}


return view;