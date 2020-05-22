public enum Status {
    OK(0), PENDING(1), ERROR(2);

    private int status;

    Status(int status) {
        this.status = status;
    }

    public static Status getByOrdinal(int ordinal) {
        for (final Status element : EnumSet.allOf(Status.class)) {
            if (element.ordinal() == ordinal) {
                return element;
            }
        }

        throw new IllegalArgumentException("Unknown status type: " + ordinal);
    }
}