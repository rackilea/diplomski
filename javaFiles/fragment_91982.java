public String submit() {
    ConfirmationBean conformationBean = new ConfirmationBean();
    confirmationBean.setOutcome("outcome"); // Set navigation case outcome where it should return back.
    FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("confirmationBean", confirmationBean);
    return "confirm";
}