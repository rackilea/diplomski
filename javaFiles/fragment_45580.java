import org.sonar.api.component.ResourcePerspectives;
 public class MySensor extends Sensor {
   private final ResourcePerspectives perspectives;

   public MySensor(ResourcePerspectives p) {
     this.perspectives = p;
   }

   public void analyse(Project project, SensorContext context) {
     Resource myResource; // to be set
     Issuable issuable = perspectives.as(Issuable.class, myResource);
     if (issuable != null) {
       // can be used
       Issue issue = issuable.newIssueBuilder()
         .setRuleKey(RuleKey.of("pmd", "AvoidArrayLoops")
         .setLine(10)
         .build();
       issuable.addIssue(issue);
     }
   }
 }