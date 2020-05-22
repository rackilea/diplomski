((ChannelExec)channel).setPty(true);
        ((ChannelExec)channel).setCommand(cmd);                        
        channel.setInputStream(null);
        ((ChannelExec)channel).setErrStream(System.err);             
        InputStream in=channel.getInputStream();
        OutputStream out = channel.getOutputStream();
        channel.connect();
        ...........
        if (isCancel) {
            log.debug("Search was canceled by user... ");                

            channel.setInputStream(null);                
            if (in != null) {
                in.close();
                in = null;
            }
            if (br != null) {
                br.close();
                br = null;
            }
            out.write(3);
            out.flush();
            try{Thread.sleep(1000);}catch(Exception ee){log.error(ee);}
        }