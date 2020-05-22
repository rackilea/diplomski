while (true) {
    if (tryReserveMemory(size, cap)) {
        return;
    }

    if (sleeps >= MAX_SLEEPS) {
        break;
    }

    try {
        if (!jlra.waitForReferenceProcessing()) {
            Thread.sleep(sleepTime);
            sleepTime <<= 1;
            sleeps++;
        }
    } catch (InterruptedException e) {
        interrupted = true;
    }
}

// no luck
throw new OutOfMemoryError("Direct buffer memory");