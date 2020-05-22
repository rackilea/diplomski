try{
    InetAddress localhost = InetAddress.getLocalHost();
    final byte[] ip = localhost.getAddress();

    SwingWorker<ListModel, InetAddress> worker = new SwingWorker<ListModel, InetAddress>()
    {
        public ListModel doInBackground()
        {
            for(int i=1;i<254;i++){
                ip[3]=(byte)i;
                final InetAddress address = InetAddress.getByAddress(ip);

                if(address.isReachable(1000)){
                    publish(address);
                    listModel1.addElement(address);
                }
            }

            return listModel1;
        }

        public void process(List<InetAddress> addresses)
        {
            for(InetAddress address : addresses)
            {
                System.out.println(address + "-Machine is turned on and can be ping.");
                Rectangle progressRec = jProgressBar1.getBounds();
                progressRec.x = 0;
                progressRec.y = 0;
                jProgressBar1.setValue(i);
                jProgressBar1.paintImmediately(progressRec);
            }
        }

        public void done()
        {
            jList1.setModel(get());
        }
    };

    worker.execute();

}catch(Exception e){
    e.printStackTrace();
}