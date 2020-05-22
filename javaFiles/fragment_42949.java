public void timeCode(Runnable code) {
    ...
    try {
        code.run();
    } catch ...
    }
    ...
}

timeCode(() -> { ...code to time... });