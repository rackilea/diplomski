final Iterator<String> iterator = actionItemClickListeners.iterator();
while (iterator.hasNext()) {
    final String listener = iterator.next();
    final boolean removeListener = listener.onSystemBackPressed();
    if (removeListener) {
        iterator.remove();
    }
    isConsume = isConsume | removeListener;
}