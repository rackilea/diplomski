In com.kenai.jbosh.BOSHClient class
//I introduced a new property
private Long rid;

//commented the following code
//long rid = requestIDSeq.getNextRID();
//and at that place added
this.rid = requestIDSeq.getNextRID();

//and finally added a new getter for rid
public Long getRid() {
    return rid;}