for(int i = 8100; i<=65535 ; i++){
                if(available(i)){
                    libre.xContext = BootstrapSocketConnector.bootstrap(libre.oooExeFolder, "localhost", i);
                    System.out.println(i);
                    break;
                    }
            }