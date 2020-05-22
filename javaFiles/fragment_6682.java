boolean isOk = false;
for (int i = 0; i < scopeFile.length; i++) {
    for (String element : scopeJWT) {
        if (scopeFile[i].contains(element)) {
            ctx.setSendZuulResponse(true);
            System.out.println(now + " --- " + "[Check Signature: OK]" + " [Verify Scope: OK]" + " [Verify expTime: OK]");
            isOk = true;
            break;
        }
    }
}
if (!isOk) {
    ctx.setSendZuulResponse(false);
    ctx.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
    System.err.println(now + " --- " + "[VERIFY SCOPE: KO]");
}