@Entity
public class WrapperEntity {

   private TeamMemberStatus memberStatus;

   @Transient
   private TeamMemberStatus getMemberStatus() {
       return this.memberStatus;
   }

   public void setMemberStatus(TeamMemberStatus memberStatus) {
       this.memberStatus = memberStatus;
   }

   @Column(name="STATUS", nullable=false, length=50)
   public String getMemberStatusAsString() {
       return memberStatus.name().toLowerCase();
   }

   public void setMemberStatusAsString(String memberStatus) {
       this.setsetMemberStatus(TeamMemberStatus.valueOf(memberStatus.toUpperCase()));
   }