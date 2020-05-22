Toolkit.getDefaultToolkit().getSystemClipboard().addFlavorListener(new FlavorListener() {

                    public void flavorsChanged(FlavorEvent e) {
                        String data = null;
                        try {

                            data = (String) Toolkit.getDefaultToolkit()
                                    .getSystemClipboard().getData(DataFlavor.stringFlavor);
                        } catch (UnsupportedFlavorException ex) {

                        } catch (IOException ex) {

                        }
                        jTextField1.setText(data);

                    }
                });