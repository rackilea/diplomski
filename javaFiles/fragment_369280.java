//Name2
            try {
            pName2 = (String)this.in.readObject();
        } catch (ClassNotFoundException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        } catch (IOException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
        this.server.sendNameToServer2(pName2, this);