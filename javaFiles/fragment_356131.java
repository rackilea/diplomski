Context.getWindows().entrySet().stream()
    .filter(e -> e.getValue().equals(Context.getDriver().getWindowHandle()))
    .map(e -> e.getKey())
    .findFirst()
    .ifPresent(k -> Context.removeWindow(k));
Context.getDriver().close();