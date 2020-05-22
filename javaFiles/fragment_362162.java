protected Member getMemberAt(int row) {
        return members.get(row);
    }

    @Override
    public Object getValueAt(int row, int col) {
        Object value = null;
        Member member = getMemberAt(row);
        switch (col) {
            case 0:
                // Need getter for last name
                break;
            case 1:
                // Need getter for first name
                break;
            case 2:
                value = member.getSS();
                break;
            case 3:
                value = member.getEmail();
            case 4:
                value = member.getPhoneNumber();
            case 5:
                value = member.getAddress();
        }
        return value;
    }