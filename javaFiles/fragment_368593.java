try {
                Session session = Session.getDefaultInstance(props, null);
                Store store = session.getStore("imaps");
                try {
                    store.connect("imap.mail.yahoo.com", _Account[_i], _Pass[_i]);
                } catch (AuthenticationFailedException e) {
                }
                if(store.isConnected() == true){
                    _textArea.setText(_Account[_i]+"/"+_Pass[_i]+ "\n" + _textArea.getText() );
                }else{

                    _textArea_1.setText(_Account[_i]+"/"+_Pass[_i] + "\n" +_textArea_1.getText());

                }
            } catch (Exception e) {
            }