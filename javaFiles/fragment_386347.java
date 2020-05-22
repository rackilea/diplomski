private void fetchDetails4(List<Group> groupList) {
    Observable.fromIterable(groupList)
            .flatMap(g -> Observable.fromIterable(g.users).map(u -> Pair.create(g, u)))
            .flatMap(p -> Observable.fromIterable(p.second.detailNames).map(n -> Pair.create(p, n)))
            .flatMap(p -> fetchDetail2(p.first.first, p.first.second, p.second)
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