public static void main(String[] args) {
    try {
        throw new Exception(new RuntimeException("Cannot move file"));
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null,
                                      "Error: " + getRootCause(ex).getMessage());
    }
}

public static Throwable getRootCause(Throwable throwable) {
    if (throwable.getCause() != null)
        return getRootCause(throwable.getCause());

    return throwable;
}