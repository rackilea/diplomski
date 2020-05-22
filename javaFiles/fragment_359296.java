Compiled from "Ordinals.java"
public final class Ordinals extends java.lang.Enum<Ordinals> {
  public static final Ordinals FIRST;

  public static final Ordinals SECOND;

  public static final Ordinals THIRD;

  private java.lang.String notation; // your custom field

  private static final Ordinals[] $VALUES; // all enum constants

  public static Ordinals[] values(); // every enum class has this static method
    Code:
       0: getstatic     #1                  // Field $VALUES:[LOrdinals;
       3: invokevirtual #2                  // Method "[LOrdinals;".clone:()Ljava/lang/Object;
       6: checkcast     #3                  // class "[LOrdinals;"
       9: areturn       

  public static Ordinals valueOf(java.lang.String); // every enum class has this static method
    Code:
       0: ldc_w         #4                  // class Ordinals
       3: aload_0       
       4: invokestatic  #5                  // Method java/lang/Enum.valueOf:(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;
       7: checkcast     #4                  // class Ordinals
      10: areturn       

  private Ordinals(java.lang.String);
    Code:
       0: aload_0       
       1: aload_1       
       2: iload_2       
       3: invokespecial #6                  // Method java/lang/Enum."<init>":(Ljava/lang/String;I)V
       6: aload_0       
       7: aload_3       
       8: putfield      #7                  // Field notation:Ljava/lang/String;
      11: return        

  public java.lang.String getNotation();
    Code:
       0: aload_0       
       1: getfield      #7                  // Field notation:Ljava/lang/String;
       4: areturn       

  static {}; // fills the $VALUES array and initializes the static fields corresponding to the enum constants
    Code:
       0: new           #4                  // class Ordinals
       3: dup           
       4: ldc           #8                  // String FIRST
       6: iconst_0      
       7: ldc           #9                  // String st
       9: invokespecial #10                 // Method "<init>":(Ljava/lang/String;ILjava/lang/String;)V
      12: putstatic     #11                 // Field FIRST:LOrdinals;
      15: new           #4                  // class Ordinals
      18: dup           
      19: ldc           #12                 // String SECOND
      21: iconst_1      
      22: ldc           #13                 // String nd
      24: invokespecial #10                 // Method "<init>":(Ljava/lang/String;ILjava/lang/String;)V
      27: putstatic     #14                 // Field SECOND:LOrdinals;
      30: new           #4                  // class Ordinals
      33: dup           
      34: ldc           #15                 // String THIRD
      36: iconst_2      
      37: ldc           #16                 // String rd
      39: invokespecial #10                 // Method "<init>":(Ljava/lang/String;ILjava/lang/String;)V
      42: putstatic     #17                 // Field THIRD:LOrdinals;
      45: iconst_3      
      46: anewarray     #4                  // class Ordinals
      49: dup           
      50: iconst_0      
      51: getstatic     #11                 // Field FIRST:LOrdinals;
      54: aastore       
      55: dup           
      56: iconst_1      
      57: getstatic     #14                 // Field SECOND:LOrdinals;
      60: aastore       
      61: dup           
      62: iconst_2      
      63: getstatic     #17                 // Field THIRD:LOrdinals;
      66: aastore       
      67: putstatic     #1                  // Field $VALUES:[LOrdinals;
      70: return        
}