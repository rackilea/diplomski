int personalContactsCount = 0;
for (int i = 0; i < contacts.length; i++) {
    if (contacts[i] instanceof PersonalContact) {
        personalContactsCount++;
    }
}  
int businessContactsCount = contacts.length - personalContactsCount;