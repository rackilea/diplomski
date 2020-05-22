class MainClass {
  public class A {
    String COLUMN_ID = "id_a";
  }

  /**
   * @dotlinkbetween{A,B}
   * @cond
   **/
   @OrAnotationToDrawLink(A.class)
  /** @endcond */
   public class B {
      String COLUMN_ID = "id_b";
      String COLUMN_FOREIGN_KEY_TO_A = "id_a_key";
    }
}