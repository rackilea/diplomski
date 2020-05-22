public boolean executeSafely(Runnable action) {
    try {
        action.run();
        return true;
    } catch (Exception x) {
        return false;
   } 
}