Context.getWindows().entrySet().stream()
    .filter(e -> e.getValue().equals(Context.getDriver().getWindowHandle()))
    .map(Map.Entry::getKey)
    .findFirst()
    .ifPresent(Context::removeWindow);
Context.getDriver().close();