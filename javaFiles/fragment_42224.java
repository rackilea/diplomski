new TryCatch() {
        Promise<Boolean> ifHostsWereReserved;
        Promise<Boolean> ifHostsReleaseCompleted;

        @Override
        protected void doTry() throws Throwable {
            ifHostsWereReserved = client.reserveHostsForOnboarding());
            ifHostsReleaseCompleted = client.releaseExtraHostsAfterOnboarding();
        }

        @Override
        protected void doCatch(Throwable e) throws Throwable {
            updateAvailableHosts(ifHostsWereReserved,
            ifHostsReleaseCompleted);
        }
}