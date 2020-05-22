List<ADStructure> structures = ADPayloadParser.getInstance().parse(scanRecord);

 for (ADStructure structure : structures) {
         String majorvalue= bytesToHex(structure.getData());
         if (structure instanceof IBeacon) {
                IBeacon iBeacon = (IBeacon) structure;
                UUID uuidvalue = iBeacon.getUUID();
                uuid=uuidvalue.toString();
                 major = String.valueOf(iBeacon.getMajor());
                 minor = String.valueOf(iBeacon.getMinor());
    }
}