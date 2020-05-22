public static void share(
    final ShareContent shareContent,
    final FacebookCallback<Sharer.Result> callback) {
new ShareApi(shareContent)
        .share(callback);
}