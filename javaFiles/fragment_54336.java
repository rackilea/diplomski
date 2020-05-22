class PhoneBook {
    private Map<String, Set<PhoneBookEntry>> firstNameMap;
    private Map<String, Set<PhoneBookEntry>> lastNameMap;
    private Map<String, Set<PhoneBookEntry>> phoneNumberMap;

    public void add(PhoneBookEntry entry) {
        Set<PhoneBookEntry> set
            = firstNameMap.computeIfAbsent(entry.firstName, k -> new HashSet<>());
        set.add(entry);

        set = lastNameMap.computeIfAbsent(entry.lastName, k -> new HashSet<>());
        set.add(entry);

        set = phoneNumberMap.computeIfAbsent(entry.phoneNumber, k -> new HashSet<>());
        set.add(entry);
    }

    public Set<PhoneBookEntry> getByFirstName(String firstName) {
        return firstNameMap.get(firstName);
    }

    public Set<PhoneBookEntry> getByLastName(String lastName) {
        return lastNameMap.get(lastName);
    }

    public Set<PhoneBookEntry> getByPhoneNumber(String phoneNumber) {
        return phoneNumberMap.get(phoneNumber);
    }

}