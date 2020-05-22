List<PostDetail> onlinePostDetail = posts.stream()
    .filter(p -> p.getDeviceStatus().equals("Online"))
    .collect(Collectors.toList());
List<PostDetail> offlinePostDetail = posts.stream()
    .filter(p -> p.getDeviceStatus().equals("Offline"))
    .collect(Collectors.toList());