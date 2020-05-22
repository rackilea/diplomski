Company createCompany = new Company("Top Mechanic");
    Person createPerson = new Person("John", "Doe");
    Address createAddress = new Address("John's Home", "123 Mystery Lane", null, "Salt Lake City", "UT", "84120", null, "Occupied");
    createCompany.residesAt(createAddress, "John's Business Mailing Address");
    createPerson.residesAt(createAddress, "Home Owner");

    companyRepository.save(createCompany); 
    personRepository.save(createPerson);