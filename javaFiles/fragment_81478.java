public class Item {
  ...
  private Set bids = new HashSet();
  public void setBids(Set bids) {
    this.bids = bids;
  }
  public Set getBids() {
    return bids;
  }
  public void addBid(Bid bid) {
    bid.setItem(this);
    bids.add(bid);
  }
  ...
}