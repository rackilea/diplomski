interface ProductSummary {
    NameSummary getName();

    interface NameSummary {
      String getValue();
    }
}