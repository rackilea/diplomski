public class DateTime2SQLServerDialect extends SQLServer2008Dialect {

   public DateTime2SQLServerDialect () {
      super();
      registerColumnType(Types.DATE, "datetime2");
   }
}