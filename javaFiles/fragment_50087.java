ArrayList<Addresses> addressesList = new ArrayList<Addresses>();
...
DropDownChoice addressesChoice = new DropDownChoice<>(
    "address",
    new PropertyModel(getModel(), "address"),
    addressesList,
    new ChoiceRenderer<>("zipCode")
);