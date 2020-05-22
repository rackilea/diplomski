public static String getConnParams() {
    String ConnectionParameter ="" ;
    int TransportTypes[] = TransportInfo.getAvailableTransportTypes();
    int wifi=0;
    int wap2=0;
    int BIS=0;
    int MDS=0;
    for(int i=0; i<TransportTypes.length; i++){
        if(TransportTypes[i]== TransportInfo.TRANSPORT_TCP_WIFI ){
        wifi  = TransportInfo.TRANSPORT_TCP_WIFI ;
        }else if(TransportTypes[i]== TransportInfo.TRANSPORT_WAP2 ){
        wap2 =  TransportInfo.TRANSPORT_WAP2; 
        }else if(TransportTypes[i]== TransportInfo.TRANSPORT_BIS_B  ){
            BIS = TransportInfo.TRANSPORT_BIS_B;
        }else if(TransportTypes[i]== TransportInfo.TRANSPORT_MDS ){
            MDS = TransportInfo.TRANSPORT_MDS;
        }
    }

    if(wifi!=0 && TransportInfo.hasSufficientCoverage(wifi)){
        ConnectionParameter = ";interface=wifi";
        return ConnectionParameter;
    }else if(wap2 !=0 &&TransportInfo.hasSufficientCoverage(wap2)){
         String carrierUid = getCarrierBIBSUid();
        if(carrierUid == null) {
            ConnectionParameter = ";deviceside=true";
        }
        else{
            ConnectionParameter = ";deviceside=true;connectionUID="+carrierUid;
        } 
        return ConnectionParameter;
    }else if(BIS !=0 && TransportInfo.hasSufficientCoverage(BIS)){
        ConnectionParameter = ";deviceside=false";
        return ConnectionParameter;
    }else if(MDS !=0 && TransportInfo.hasSufficientCoverage(MDS)){
        ConnectionParameter = ";deviceside=false";
        return ConnectionParameter;
    }else{
        ConnectionParameter = ";deviceside=true";       
        return ConnectionParameter;
    }


}