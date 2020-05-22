@RequiredArgsConstructor
public class FieldExclusionStrategy implements ExclusionStrategy { 

   @NonNull
   private final Collection<String> serializedFields;

   @Override
   public boolean shouldSkipField(FieldAttributes f) {
      if(serializedFields.contains(f.getName())) return false;
      return true;
   }

   @Override
   public boolean shouldSkipClass(Class<?> clazz) { return false; }

}