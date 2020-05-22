String string = getItSomehowWithoutClassCastException();

try {
    Integer integer = Integer.valueOf(string);
} catch (NumberFormatException e) {
    throw new ConverterException(new FacesMessage("Value is not an integer."));
}