CustomerSearch customerSrch = new CustomerSearch();
  CustomerSearchBasic customerSrchBsc = new CustomerSearchBasic();

  SearchStringCustomField custentity_externalid =  new SearchStringCustomField();
  custentity_externalid.setInternalId("1015");
  custentity_externalid.setSearchValue(externalID);
  custentity_externalid.setOperator(SearchStringFieldOperator.is);

  SearchCustomFieldList searchCustomFieldList = new SearchCustomFieldList();
  SearchCustomField[] SearchCustomFieldArray = {custentity_externalid};
  searchCustomFieldList.setCustomField(SearchCustomFieldArray);
  customerSrchBsc.setCustomFieldList(searchCustomFieldList);
  customerSrch.setBasic(customerSrchBsc);


  SearchResult searchResult = _service.search(customerSrch);