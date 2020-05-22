public void setGridPresenter(VerticalGridPresenter gridPresenter) {
    if (gridPresenter == null) {
        throw new IllegalArgumentException("Grid presenter may not be null");
    }
    mGridPresenter = gridPresenter;
    ...
}