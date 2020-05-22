@Builder
public AnIdentifier(@NonNull String mandatoryIdPart, String optionalIdPart1, String optionalIdPart2) {
    this.mandatoryIdPart = mandatoryIdPart;
    this.optionalIdPart1 = Optional.ofNullable(optionalIdPart1);
    this.optionalIdPart2 = Optional.ofNullable(optionalIdPart2);
}