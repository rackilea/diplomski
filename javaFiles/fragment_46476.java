if (root.right == null || root.left == null) {
    if (root.left == null) {
        if (root.right == null) {
            log.debug("(null, null)");
        } else {
            log.debug(String.format("(null, %s)", root.right.data);
        }
    } else {
        log.debug(String.format("(%s, null)", root.left.data);
    }
} else {
    log.debug(String.format("(%s, %s)", root.left.data, root.right.data);
}