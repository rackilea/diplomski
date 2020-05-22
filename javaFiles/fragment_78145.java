MessageParameter<?> otherElement = getOtherElement();
for (MessageParameter<?> element : payload) {
    List<?> unmarshalledList = element.unmarshal(byteArray);
    // unmarshalledList can be re-assigned from another parameterized type
    unmarshalledList = otherElement.unmarshal(byteArray);
    element.getLength(unmarshalledList);  // error
}