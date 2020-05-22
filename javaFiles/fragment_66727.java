public List<Element> search(List<Element> allElements, UserInputs criteria) {
    List<Element> acceptedElements = new ArrayList<>();
    for (Element e : allElements) {
        if (isAccepted(e, criteria)) {
            acceptedElements.add(e);
        }
    }
    return acceptedElements;
}

private boolean isAccepted(Element e, UserInputs criteria) {
    String firstName = criteria.getFirstName();
    if (isCriterionFilled(firstName) && !hasFirstName(e, firstName)) {
        return false;
    }

    String lastName = criteria.getLastName();
    if (isCriterionFilled(lastName) && !hasLastName(e, lastName)) {
        return false;
    }

    String phone = criteria.getPhone();
    if (isCriterionFilled(phone) && !hasPhone(e, phone)) {
        return false;
    }

    return true;
}