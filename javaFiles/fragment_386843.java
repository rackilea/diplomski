modalConfirmWindow.setCloseButtonCallback(new ModalWindow.CloseButtonCallback() {

                    private static final long serialVersionUID = 10093L;

                    public boolean onCloseButtonClicked(AjaxRequestTarget target) {
                        ParentPage.this.isCancelButtonClicked = true;
                        return true;
                    }
                });
                modalConfirmWindow.setWindowClosedCallback(new ModalWindow.WindowClosedCallback() {

                    private static final long serialVersionUID = 10094L;

                    public void onClose(AjaxRequestTarget target) {
                        if (ParentPage.this.isCancelButtonClicked) {
                            String javascript = "document.getElementById('"+ scheduledTimeField.getMarkupId() +"').value = \"\";" +
                                                "document.getElementById('"+ deadLineField.getMarkupId() +"').value = \"\";" +
                                                "document.getElementById('"+ totalLabel.getMarkupId()+"').style.display = 'none';" +
                                                "document.getElementById('"+ choice.getMarkupId() +"').options[0].selected = 'selected';" +
                                                "document.getElementById('"+ choice.getMarkupId() +"').disabled = true;" +
                                                "document.getElementById('"+ userAssignmentInfoPanel.getMarkupId() +"').style.display = 'none';";
                            target.appendJavascript(javascript);
                        }                            
                    }
                });