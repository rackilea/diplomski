ArrayList<String[]> rawEKGs  = ekgFile.getForMrno( docInfo.getMedicalRecordNumber() );
 UncEKG.COL_NAMES[] values = UncEKG.COL_NAMES.values();
 for (String[] parts : rawEKGs) {
    for (int i=0; i< parts.length; i++ )
    {
       Result result = docInfo.getResult();
       boolean process = true;
       switch (values[i]) {
           case UncEKG.COL_NAMES.C_VENT_RATE:
                break;
           default: process = false;
       }
    }
 }