@Override
public IModel<HeavyBean> model(final HeavyBean heavyBean) {
    final Integer id = heavyBean.getId();
    return new LoadableDetachableModel<HeavyBean>() {
        @Override
        protected HeavyBean load() {
            return ServiceLocator.get(HeavyDao.class).get(id);
        }
    };
}