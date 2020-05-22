private void fetchDetails(List<Group> groupList) {
    groupList.stream()
            .flatMap(g -> g.users.stream().map(u -> new UserWithGroup(g, u)))
            .flatMap(ug -> ug.user.detailNames.stream().map(n -> new DetailWithUser(ug.group, ug.user, n)))
            .forEach(d -> fetchDetail(d.group, d.user, d.detailName));
}