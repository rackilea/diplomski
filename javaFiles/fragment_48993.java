public static void share(final String message,
    final ShareContent shareContent,
    final FacebookCallback<Sharer.Result> callback) {
new ShareApi(message, shareContent)
        .share(callback);
}