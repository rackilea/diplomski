@Override
                public void onCoinsReceived(Wallet wallet, Transaction tx, Coin prevBalance, Coin newBalance) {
                    System.out.println("Received a transaction.");
                    for (int i = 0; i < tx.getOutputs().size(); i++) {
                        for (ECKey addr : wallet().getImportedKeys()) {
                            Address expectedAddr = addr.toAddress(Main.PARAMS);
                            for (int j = 0; j < tx.getOutputs().size(); j++) 
                                String incoming = tx.getOutputs().get(i).getAddressFromP2PKHScript(Main.PARAMS)
                                        .toBase58();
                                if (incoming.equals(expectedAddr)){
                                 // Enter your code here
                                }
                            }
                        }
                    }
                }