if(!timestamps.contains(minTimestamp)){
            timestamps.add(minTimestamp);
        }

        if(eafedo5.getServiceInformation(eafedo5Count).getTimestamp() ==minTimestamp){
            for(CHostNeighbor n : hostNeighborsEafedo5){
                msgsCountDo += n.getInboundMsgs();
            }
            eafedo5Count--;
        }
        if(eafedo6.getServiceInformation(eafedo6Count).getTimestamp() ==minTimestamp){
            for(CHostNeighbor n : hostNeighborsEafedo6){
                msgsCountDo += n.getInboundMsgs();
            }
            eafedo6Count--;
        }
        if(eafedo7.getServiceInformation(eafedo7Count).getTimestamp() ==minTimestamp){
            for(CHostNeighbor n : hostNeighborsEafedo7){
                msgsCountDo += n.getInboundMsgs();
            }
            eafedo7Count--;
        }

        msgsDo.add(msgsCountDo);