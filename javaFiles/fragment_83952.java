...
    .map(time -> "item\n")
    .map(item -> item = null)
    .map(item -> {
        try {
            return item.toString();
        } catch (NullPointerException e) {
            return "item with error emitted";
    })
    //no onErrorResumeNext()
    .subscribe ...