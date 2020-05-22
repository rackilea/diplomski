@Override
    public void setValueAt(Object value, int rowIndex, int colIndex) {
        Member member = getMemberAt(rowIndex);
        switch (colIndex) {
            case 0:
                member.setName(value.toString(), member.getLastName());
                break;
            case 1:
                member.setName(member.getFirstName(), value.toString());
                break;
            case 2:
                if (value instanceof Integer) {
                    member.setSS((Integer) value);
                }
                break;
            case 3:
                member.setEmail(value.toString());
                break;
            case 4:
                if (value instanceof Integer) {
                    member.setPhoneNumber((Integer)value);
                }
                break;
            case 5:
                member.setAddress(value.toString());
                break;
        }
        fireTableRowsUpdated(rowIndex, colIndex);
    }
}