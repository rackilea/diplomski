public void onMyButtonClicked() {
    final FacesContext context = FacesContext.getCurrentInstance();
    executorService.execute(new Runnable() {

        @Override
        public void run() {
            try {
                // You can probably use facesContext here
                doSomethingThatTakesLong();
            } catch (Exception e) {
                final PushContext pushContext = PushContextFactory.getDefault().getPushContext();
                pushContext.push("/errors", new FacesMessage(FacesMessage.SEVERITY_WARN, "Exception caught", "Explanatory message"));
            }
        }
    });
}