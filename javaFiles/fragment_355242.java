for(int i=0;i<numContacts;i++) {
        for(int j=i+1;j<numContacts;j++) {
            if(contactsArray [i][1].compareTo(contactsArray [j][1])>0) {
                String[] temp = contactsArray [i];
                contactsArray [i] = contactsArray [j];
                contactsArray [j] = temp;
            }
        }
  }