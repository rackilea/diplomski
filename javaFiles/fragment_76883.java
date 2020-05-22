Pattern p;
synchronized (list) {
    if (list.isEmpty()) {
        p = null;
    } else {
        p = list.remove(0);
    }
}
if (p != null) {
    process(p);  // we don't want to call process(..) while still synchronized!
}