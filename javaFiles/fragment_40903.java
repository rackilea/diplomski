public void getTraffic() throws SigarException, InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {

                long oldReceived = 0, oldSend = 0, newReceived, newSend;

                while (true){
                    try{

                        Long[] m = getMetric();

                        newReceived = m[0];
                        newSend = m[1];

                        if(oldReceived != newReceived || oldSend != newSend){ //if the result is different from the previous

                            oldReceived = newReceived; //put the new result to old result
                            oldSend = newSend; //put the new result to old result

                            if(oldReceived > 999 || oldSend > 999 && oldReceived == 0 || oldSend == 0){
                                System.out.print("totalrx(download): ");
                                System.out.println("\t" + Sigar.formatSize(newReceived));
                                System.out.print("totaltx(upload): ");
                                System.out.println("\t" + Sigar.formatSize(newSend));
                                System.out.println("-----------------------------------");
                            }

                        }
                        Thread.sleep(1000);
                    }catch (SigarException e){
                        System.out.println(TAG + "Failed to get Network Traffic, SigarException >> " + e.toString());
                    }catch (InterruptedException e){
                        System.out.println(TAG + "Failed to get Network Traffic, InterruptedException >> " + e.toString());
                    }
                    if (stopGettingNetworkBandwidth)break;if (stopGettingNetworkBandwidth)break;
                }
            }
        }).start();
    }