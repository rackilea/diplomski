bConnect.setOnClickListener(new Button.OnClickListener() {
                public void onClick(View v) {
                    try {
                        Socket s = new Socket("192.168.0.117", 4447);
                        out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
                        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                    } catch (UnknownHostException e) {
                        tView.setText(e.toString());
                        Log.v("Tcp",e.toString());
                    } catch (IOException e) {
                        tView.setText(e.toString());
                        Log.v("Tcp",e.toString());
                    }catch (Exception e) {
                        tView.setText(e.toString());

                    } 
                }
            });

            bSend.setOnClickListener(new Button.OnClickListener() {
                public void onClick(View v) {
                    try {
                        String outMsg = ((EditText)findViewById(R.id.address)).getText().toString().trim();
                        out.write(outMsg);
                        out.flush();
                        Log.i("TcpClient", "sent: " + outMsg);  
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }


                    finally{

                    }
                    }


                });