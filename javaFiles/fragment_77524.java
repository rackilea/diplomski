@NodeEntity (label="Company")
public class Company {
    ...

    @Relationship(type="RESIDES_AT", direction=Relationship.OUTGOING)
    Set<CompanyResidesAtAddress> residesAt = new HashSet<>();
}

@NodeEntity (label="Address")
public class Address {
   ...
   @Relationship(type="RESIDES_AT", direction=Relationship.INCOMING)
   Set<PersonResidesAtAddress> personResidances = new HashSet<>();

   @Relationship(type="RESIDES_AT", direction=Relationship.INCOMING)
   Set<CompanyResidesAtAddress> companyResidances = new HashSet<>();
}

@RelationshipEntity(type = "RESIDES_AT")
public class CompanyResidesAtAddress {
   ...
   @StartNode
   private Company startNode;

   private ResidesAt residesAt;

   @EndNode
   private Address address;
}

public class ResidesAt implements RelationshipType{

   ... // Common Attributes & methods

   @Override
   public String name() {
      return this.getClass().getSimpleName().toUpperCase();
   }
}