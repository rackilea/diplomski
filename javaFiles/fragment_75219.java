catch (SQLException e) {
  Throwable cause = e.getCause();
    while (cause != null) {
     System.out.println(cause);
     cause = cause.getCause();
    }
}