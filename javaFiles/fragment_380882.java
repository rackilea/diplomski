excel.setCell(name1, Optional.of(contract)
                             .map(Contract::getContactInfo)
                             .map(ContactInfo::getPosition)
                             .orElse(null));
excel.setCell(name2, Optional.of(contract)
                             .map(Contract::getEntitledPerson)
                             .map(Person::getEmail)
                             .orElse(null));