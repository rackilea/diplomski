myWebView.setWebViewClient(new MyWebViewClient(new MyCallBack(){
                    @Override
                    public void UpdateMyText(String mystr) {
                        editText.setText(mystr);
                    }
                }));