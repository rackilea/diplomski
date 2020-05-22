public class CreditComplex {

    private String bcnr;
    public String getBcnr() { return bcnr; }
    public void setBcnr(String bcnr) { this.bcnr = bcnr; }

    private String relationshipName;
    public String getRelationshipName() { return relationshipName; }
    public void setRelationshipName(String relationshipName) { this.relationshipName = relationshipName; }

    private List<Borrower> borrowers;
    public List<Borrower> getBorrowers() { return borrowers; }
    public void setBorrowers(List<Borrower> borrowers) { this.borrowers = borrowers; }

}