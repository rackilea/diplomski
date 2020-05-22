ComboBoxItem portSelect = new ComboBoxItem("PORT_ATTRIB", "") {

      @Override
      public Criteria getPickListFilterCriteria() {
        if (getValue() != null && getValue() instanceof String) {
          criteria = new AdvancedCriteria(OperatorId.AND, new Criterion[]{new Criterion("portValue",
              OperatorId.EQUALS, getDisplayValue())});
        }
        return criteria;
      }
    };