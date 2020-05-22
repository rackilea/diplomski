public static void logout() throws Throwable {
    session.clear();
    response.removeCookie("rememberme");
    Security.invoke("onDisconnected");
    flash.success(Messages.get("secure.logout", "You have been successfully logged out"));

    String returnUrl = flash.get("returnUrl");
    redirect(returnUrl == null ? "/" : returnUrl);
}