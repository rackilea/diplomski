List<Contact> serverContacts = adapter.fromJson(chatMessage.getContent());
    if (serverContacts != null) {
        List<Contact> phoneContact = getPhoneContact(getContext());
        for (int i = 0; i < serverContacts.size(); i++) {
            for (int j = 0; j < phoneContact.size(); j++) {
                if(serverContacts.get(i).getCellphoneNumber().equals(phoneContact.get(j).getCellphoneNumber())) {
                    System.out.println("Match Found " + i);
                    break;
                }
            }
        }
    }