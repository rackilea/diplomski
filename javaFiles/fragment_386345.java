private void fetchDetails2(List<Group> groupList) {
    Observable.fromIterable(groupList)
            .flatMap(g -> Observable.fromIterable(g.users).map(u -> new UserWithGroup(g, u)))
            .flatMap(ug -> Observable.fromIterable(ug.user.detailNames).map(n -> new DetailWithUser(ug.group, ug.user, n)))
            .flatMap(d -> mUserApi.getDetail(d.group.id, d.user.id, d.detailName)
                    .map(detail -> {
                        detail.group = d.group;
                        detail.user = d.user;
                        return detail
                    }))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(detail -> {
                ...
            });
}