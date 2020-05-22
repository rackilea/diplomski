class PersonDetails {
    private Person person;
    private Address address;

    ...
}


PersonDetails personDetails = new PersonDetails();
personDetails.setPerson(new Person());
personDetails.setAddress(new Address());

model.addAttribute(“personDetails”, personDetails);


<form:form action=”registration” command=”personDetails”>