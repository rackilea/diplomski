if (null != currProcedure.get()) {
    currProcedure.get().cancel(true);
}
if (null != updater.get()) {
    updater.get().cancel();
}