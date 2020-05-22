public class AccountKey {
  private Integer rId;
  private Integer conId;
  private Integer actNbr;

  public Integer getrId() {
    return rId;
  }

  public void setrId(Integer rId) {
    this.rId = rId;
  }

  public Integer getConId() {
    return conId;
  }

  public void setConId(Integer conId) {
    this.conId = conId;
  }

  public Integer getActNbr() {
    return actNbr;
  }

  public void setActNbr(Integer actNbr) {
    this.actNbr = actNbr;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    AccountKey that = (AccountKey) o;

    if (rId != null ? !rId.equals(that.rId) : that.rId != null) return false;
    if (conId != null ? !conId.equals(that.conId) : that.conId != null) return false;
    return actNbr != null ? actNbr.equals(that.actNbr) : that.actNbr == null;
  }

  @Override
  public int hashCode() {
    int result = rId != null ? rId.hashCode() : 0;
    result = 31 * result + (conId != null ? conId.hashCode() : 0);
    result = 31 * result + (actNbr != null ? actNbr.hashCode() : 0);
    return result;
  }
}