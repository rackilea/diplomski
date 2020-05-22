DropDownChoice addressesChoice = new DropDownChoice<>(
    "address",
    new PropertyModel(getModel(), "address"),
    new ArrayList<Address>(),
    new ChoiceRenderer<>("zipCode")
);