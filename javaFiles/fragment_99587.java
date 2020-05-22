// new way
void initializePresenter() {
    og = og.plus(new OverviewModule(this)); // Note this line
    og.inject(this);
    mPresenter.initialize(mVendorId);
}