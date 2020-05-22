@XmlRootElement(name = "data")
  static class Data
  {
    private String orderDetail = "";

    @XmlElement (name = "order-detail", nillable = true)
    public String getOrderDetail() {
        if(orderDetail.length() == 0) {
            return null;
        }
        return orderDetail;
    }
    public void setOrderDetail(String orderDetail)  { 
        if(null == orderDetail) {
            this.orderDetail = "";
        } else {
            this.orderDetail = orderDetail; 
        }
    }
  }