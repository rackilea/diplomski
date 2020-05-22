try {
    // Do foo with is and db
} catch (Exception e) {
    // Do bar for exception handling
} finally {
    try {
        is.close();
        db.close();
    } catch (Exception e2) {
      // gah!
    }
}