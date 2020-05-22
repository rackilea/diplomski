// Removed field and searchRule mapping as those are already in the 
    // primary key object, updated setters/getters to pull properties from
    // primary key object
    public Field getField() {
        return fieldRulePK != null ? fieldRulePK.getField() : null;
    }
    public void getField(Field field) {
        // ... parameter validation ...
        if (fieldRulePK == null) fieldRulePK = new FieldRulePK();
        fieldRulePK.setField(field);
    }

    public SearchRule getSearchRule() {
        return fieldRulePK != null ? fieldRulePK.getSearchRule() : null;
    }
    public void setSearchRule(SearchRule searchRule) {
        // ... parameter validation ...
        if (fieldRulePK == null) fieldRulePK = new FieldRulePK();
        fieldRulePK.setSearchRule(searchRule);
    }