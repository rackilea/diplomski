private List<myList> returnData;

  private void addReturnData(final List<myList> data) {
    this.returnData.addAll(data);
  }

  public void setReturnData(final List<myList> returnData) {
    this.returnData = returnData;
  }

  public List<myList> getReturnData() {
    return returnData;
  }

  public List<myList> listDetail(@Valid final ListRequest listRequest) throws MyException {

    returnData = new ArrayList<myList>();
    for (final ListRequestDetail listRequestDetail : ((ListRequest) listRequest).getData()) {
      addReturnData(myRepository.myDetails(listRequestDetail.getMyData1(), listRequestDetail.getMyData2()));
    }
    return returnData;
  }