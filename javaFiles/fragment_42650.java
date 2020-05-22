String mySessionId = null;
for (Cookie cookie : cookies) {
    if ("MYSESSIONID".equals(cookie.getName())) {
        mySessionId = cookie.getValue();
    }
}
// returning code is above
sessionMap = gcpSessionService.getGcpSession(swgcSessionId);
if (sessionMap != null) {
    access = (Access) sessionMap.get(ACCESS);
}