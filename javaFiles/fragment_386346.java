private void fetchDetails3(List<Group> groupList) {
    groupList.stream()
            .flatMap(g -> g.users.stream().map(u -> Pair.create(g, u)))
            .flatMap(p -> p.second.detailNames.stream().map(n -> Pair.create(p, n)))
            .forEach(p -> fetchDetail(p.first.first, p.first.second, p.second));
}