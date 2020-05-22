Create or Replace AND RESOLVE Java Source Named "JAggrFun" As
import java.math.BigDecimal;

class JAggrFun {
/*
Supporting Java class for dummy aggregate function
Implemented methods:
initiate   - dummy
iterate    - dummy
terminate  - return "Hello World"
merge (is not required)

*/
  final static BigDecimal SUCCESS = new BigDecimal(0);
  final static BigDecimal ERROR = new BigDecimal(1);

  static public BigDecimal ODCIInitialize(BigDecimal[] sctx) {

    return SUCCESS; 
  }

  static public BigDecimal ODCIIterate(BigDecimal ctx, String str) { 

     return SUCCESS;                                                                 
  } 

  static public BigDecimal ODCITerminate(BigDecimal ctx, String[] str) {

    str[0] = "Hello World";
    return SUCCESS;
  } 

}
/