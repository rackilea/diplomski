Document twoStepDocA = Jsoup.connect("https://www.WEBSITE.net/login/two-step")

        .data("cookieexists", "false")
        .data("code", code)
        .data("trust", "1")
        .data("save", "Confirm")
        .data("provider", "totp")
        .data("_xfConfirm", "1")
        .data("_xfToken", "")
        .data("remember", "0")
        .data("redirect", "https://www.WEBSITE.net")
        .cookies(loginForm.cookies())
        .post()
    ;