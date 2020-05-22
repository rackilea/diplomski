@Override
public void start(AcceptsOneWidget panel, EventBus eventBus) {
    view.setPresenter(this);
    fetchUsers();
    panel.setWidget(view.asWidget());

}

@Override
        public void onSuccess(Method method, List<GWTUser> response) {
            view.setUserList(response);
        }