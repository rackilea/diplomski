String outcome = String.format(
    "viewB?faces-redirect=true&amp;foo=%s&amp;bar=%s",
        URLEncoder.encode(foo, "UTF-8"),
        URLEncoder.encode(bar, "UTF-8"));

return outcome;