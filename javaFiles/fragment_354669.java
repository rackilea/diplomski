@JsonCreator
public PolicyRatingRequestDMO(@JsonProperty("policyInfo") PolicyDMO policyDMO,
         @JsonProperty("allInsuredInd") String allInsuredInd,
         @JsonProperty("medicareMediaidInd") String medicareMediaidInd,
         @JsonProperty("driversGreaterThan65") boolean driversGreaterthan65){
    this.policyDMO = policyDMO;
    this.allInsuredInd = allInsuredInd;
    this.medicareMediaidInd = medicareMediaidInd;
    this.driversGreaterthan65 = driversGreaterthan65;
}