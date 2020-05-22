public static <T extends Comparable<T>> void sorted(final List<T> actual) {
    try {
        assertThat(actual).isSortedAccordingTo(Comparator.reverseOrder());
    } catch (AssertionError e) {
        LOGGER.error(e.getMessage(), e);
        throw e;
    }
}