@ManyToOne()
@JoinColumn(name="uaccn_id")
private SpireAccessionNumberMap spireAccessionNumberMap;


public SpireAccessionNumberMap getSpireAccessionNumberMap() {
    return spireAccessionNumberMap;
}

public void setSpireAccessionNumberMap(
        SpireAccessionNumberMap spireAccessionNumberMap) {
    this.spireAccessionNumberMap = spireAccessionNumberMap;
}