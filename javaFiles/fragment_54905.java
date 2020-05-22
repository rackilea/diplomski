class Address {
    private BigDecimal yourField;

    /* …cut… */

    public Map<String, Object> toMap() {
        Map<String, Object> raw = new HashMap<>();
        raw.put("yourField", this.yourField.toPlainString());
        /* more fields */
        return raw;
    }

    @Override
    public String toString() {
        // add JSON processing exception handling, dropped for readability
        return new ObjectMapper().writeValueAsString(this.toMap());
    }
}

class Employee {
    private Address address;

    /* …cut… */

    public Map<String, Object> toMap() {
        Map<String, Object> raw = new HashMap<>();
        raw.put("address", this.address.toMap());
        /* more fields */
        return raw;
    }

    @Override
    public String toString() {
        // add JSON processing exception handling, dropped for readability
        return new ObjectMapper().writeValueAsString(this.toMap());
    }
}