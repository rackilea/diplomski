create or replace
PACKAGE JAggrFunPackage authid current_user AS
  FUNCTION ODCIInitialize(
                  ctx OUT NOCOPY NUMBER
                  ) RETURN NUMBER
                  AS LANGUAGE JAVA
    NAME 'JAggrFun.ODCIInitialize(
              java.math.BigDecimal[]) return java.math.BigDecimal';

  FUNCTION ODCIIterate(
                  ctx IN NUMBER,
                  str VARCHAR2) RETURN NUMBER
                  AS LANGUAGE JAVA
    NAME 'JAggrFun.ODCIIterate(
              java.math.BigDecimal,
              java.lang.String) return java.math.BigDecimal';

  FUNCTION ODCITerminate(
                  ctx IN NUMBER,
                  str OUT VARCHAR2) RETURN NUMBER
                  AS LANGUAGE JAVA
    NAME 'JAggrFun.ODCITerminate(
              java.math.BigDecimal,
              java.lang.String[]) return java.math.BigDecimal';

END JAggrFunPackage;
/