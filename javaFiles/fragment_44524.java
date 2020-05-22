@GroupSequence({ BasicEngineChecks.class, ExtendedEngineChecks.class })
public class Engine {
   @NotEmpty(groups = BasicEngineChecks.class)
   private String name;

   @NotNull(groups = BasicEngineChecks.class)
   private int power;

   @NotNull(groups = ExtendedEngineChecks.class)
   private int color;

   // ...
}