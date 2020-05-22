public class BurnProfileHourlyNomData {
  private Integer stageId;
  private Integer qty;
  private Integer hoursInStage;
  private Integer hoursPassed;
  private Integer hourlyQty;
  private Integer FlowedQty;

  public Integer getStageId() {
    return stageId;
  }

  public void setStageId(Integer stageId) {
    this.stageId = stageId;
  }

  public Integer getQty() {
    return qty;
  }

  public void setQty(Integer qty) {
    this.qty = qty;
  }

  public Integer getHoursInStage() {
    return hoursInStage;
  }

  public void setHoursInStage(Integer hoursInStage) {
    this.hoursInStage = hoursInStage;
  }

  public Integer getHoursPassed() {
    return hoursPassed;
  }

  public void setHoursPassed(Integer hoursPassed) {
    this.hoursPassed = hoursPassed;
  }

  public Integer getHourlyQty() {
    return hourlyQty;
  }

  public void setHourlyQty(Integer hourlyQty) {
    this.hourlyQty = hourlyQty;
  }

  public Integer getFlowedQty() {
    return FlowedQty;
  }

  public void setFlowedQty(Integer flowedQty) {
    FlowedQty = flowedQty;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    BurnProfileHourlyNomData that = (BurnProfileHourlyNomData) o;

    if (stageId != null ? !stageId.equals(that.stageId) : that.stageId != null) return false;
    if (qty != null ? !qty.equals(that.qty) : that.qty != null) return false;
    if (hoursInStage != null ? !hoursInStage.equals(that.hoursInStage) : that.hoursInStage != null)
      return false;
    if (hoursPassed != null ? !hoursPassed.equals(that.hoursPassed) : that.hoursPassed != null)
      return false;
    if (hourlyQty != null ? !hourlyQty.equals(that.hourlyQty) : that.hourlyQty != null)
      return false;
    return FlowedQty != null ? FlowedQty.equals(that.FlowedQty) : that.FlowedQty == null;
  }

  @Override
  public int hashCode() {
    int result = stageId != null ? stageId.hashCode() : 0;
    result = 31 * result + (qty != null ? qty.hashCode() : 0);
    result = 31 * result + (hoursInStage != null ? hoursInStage.hashCode() : 0);
    result = 31 * result + (hoursPassed != null ? hoursPassed.hashCode() : 0);
    result = 31 * result + (hourlyQty != null ? hourlyQty.hashCode() : 0);
    result = 31 * result + (FlowedQty != null ? FlowedQty.hashCode() : 0);
    return result;
  }
}