...
    httpGetFile(url, new AsyncCallback<String>() {
        public void onFailure(Throwable caught) {
            xmlData = "Error";
        }

        public void onSuccess(String xmlText) {
            xmlData = xmlText;
        }
    }
....