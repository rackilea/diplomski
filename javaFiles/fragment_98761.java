@PostMapping("/login")
public AuthUser login(InputStream inputStream, HttpServletRequest request) throws Exception {

    final String ipAddress = request.getRemoteAddr();
    if (ipAddress == null || ipAddress.equals("")) {
        throw new Exception("Nie udało się ustalić adresu IP klienta");
    }

    Login login = loginMgr.prepareLogin(inputStream);
    return authentication
            .login(login.getUsername(), login.getPasword(), ipAddress);
}