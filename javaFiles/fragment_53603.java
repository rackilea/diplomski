public AbcEntry generateEntry(ISOMsgZxc isoMsgZxc) {
        AbcEntry abcEntry = new AbcEntry();
        abcEntry.setEntryMid(isoMsgZxc.getMid());

        String mti = isoMsgZxc.getMti() + "." + isoMsgZxc.getProcessingCode().substring(0, 2);
        String transType = "";
        BigDecimal amt = new BigDecimal("00.000");

        switch (mti) {
            case "1234.14":
            case "0212.02":
                transType = "S";
                amt = new BigDecimal(isoMsgZxc.getTransactionAmount()).negate();
                break;
            case "0400.20":
            case "0200.22":
                transType = "R";
                amt = new BigDecimal(isoMsgZxc.getTransactionAmount());
                break;
        }

        abcEntry.setEntryType(transType);
        return abcEntry;
}