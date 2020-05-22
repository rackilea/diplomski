public class Market {
  private String marketplace;  
  private String orderdate;  
  private Double datamount;
  private Integer count;  
  private Double result;

  public String getMarketplace() {
    return marketplace;
  }

  public void setMarketplace(String marketplace) {
    this.marketplace = marketplace;
  }

  public String getOrderdate() {
    return orderdate;
  }

  public void setOrderdate(String orderdate) {
    this.orderdate = orderdate;
  }

  public Double getDatamount() {
    return datamount;
  }

  public void setDatamount(Double datamount) {
    this.datamount = datamount;
  }

  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public Double getResult() {
    return result;
  }

  public void setResult(Double result) {
    this.result = result;
  }

  public Market(String marketplace, String orderdate, Double datamount, Integer count, Double result) {
    this.marketplace = marketplace;
    this.orderdate = orderdate;
    this.datamount = datamount;
    this.count = count;
    this.result = result;
  }

}