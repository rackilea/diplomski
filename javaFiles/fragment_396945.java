public class TestBreak2 {
  public TestBreak2();
    Code:
       0: aload_0       
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return        

  public static void main(java.lang.String[]);
    Code:
       0: bipush        10
       2: istore_1      
       3: iconst_5      
       4: istore_2      
       5: bipush        9
       7: newarray       int
       9: dup           
      10: iconst_0      
      11: iconst_5      
      12: iastore       
      13: dup           
      14: iconst_1      
      15: bipush        10
      17: iastore       
      18: dup           
      19: iconst_2      
      20: bipush        6
      22: iastore       
      23: dup           
      24: iconst_3      
      25: bipush        90
      27: iastore       
      28: dup           
      29: iconst_4      
      30: iconst_0      
      31: iastore       
      32: dup           
      33: iconst_5      
      34: iconst_1      
      35: iastore       
      36: dup           
      37: bipush        6
      39: iconst_0      
      40: iastore       
      41: dup           
      42: bipush        7
      44: bipush        7
      46: iastore       
      47: dup           
      48: bipush        8
      50: bipush        10
      52: iastore       
      53: astore_3      
      54: iload_2       
      55: iload_1       
      56: if_icmpge     71
      59: aload_3       
      60: iload_2       
      61: iaload        
      62: ifeq          71
      65: iinc          2, 1
      68: goto          54
      71: return        
}