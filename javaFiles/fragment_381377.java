HelpDeskTestServiceAsync asyncService = GWT.create(HelpDeskTestService.class);

asyncService.postToRemoteServer(
                "http://xx.xx.xx.xx/sdpapi/request/", 
                new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable caught)  {
                        Window.alert("Failure getting XML through proxy");
                    }

                    @Override
                    public void onSuccess(String result) {
                        processXML(result);
                    }
                });