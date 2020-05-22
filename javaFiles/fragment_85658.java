@Override
public void More ...onViewCreated(View view, Bundle savedInstanceState) {
    ViewGroup gridDock = (ViewGroup) view.findViewById(R.id.browse_grid_dock);
    mGridViewHolder = mGridPresenter.onCreateViewHolder(gridDock);
    gridDock.addView(mGridViewHolder.view);

    updateAdapter();
}