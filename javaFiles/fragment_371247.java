@JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = FhirJsonValueFilter.class)
class Resource implements FhirTypeInterface {
  ...

  @Override
  public boolean isEmpty() {
    //Details omitted for simplicity
  }
}