send.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        GMailSender sender = new GMailSender(userid.getText()
                                .toString(), password.getText().toString());
                        try {
                            sender.sendMail(subject.getText().toString(), body
                                            .getText().toString(), from.getText().toString(),
                                    to.getText().toString());
                        } catch (Exception e) {
                            Log.e("SendMail", e.getMessage(), e);
                        }
                    }
                });
                thread.start();
            }
        });