Log prev = null;
Log current = it.next();
while (it.hasNext()) {
    prev = current;
    current = it.next();
    if (current.getLogMessage().equals(next.getLogMessage())) {
        it.remove();
    }
}