kazananiBelirleButon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                SwingWorker worker = new SwingWorker() {

                    @Override
                    public Object construct() {
                        progressBar.setVisible(true);
                        progressBar.setIndeterminate(true);

                        try {

                            HashMap<String, Object> randoms = randSonuc.generateSignedIntegers(5, 0, 10);
                            System.out.println(randoms.toString());
                            String test = randoms.toString().substring(randoms.toString().indexOf("{r")+1, randoms.toString().indexOf(", da")).replace("random=", "{\"random\":") + "}";

                            System.out.println(tarihiYazdir(test,14));
                            cekilisTarihiTextPane.setText(tarihiYazdir(test,2).toString());
                            sonucPane.setText("\n"+sonuclariYazdir(test,0));

                        } catch (RandomOrgSendTimeoutException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        } catch (RandomOrgKeyNotRunningError e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        } catch (RandomOrgInsufficientRequestsError e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        } catch (RandomOrgInsufficientBitsError e1) {
                            System.out.print("lol");
                            e1.printStackTrace();
                        } catch (RandomOrgBadHTTPResponseException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        } catch (RandomOrgRANDOMORGError e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        } catch (RandomOrgJSONRPCError e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        } catch (MalformedURLException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        } catch (IOException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                    }
                     return 0;
                }
            };
            worker.start();
        });