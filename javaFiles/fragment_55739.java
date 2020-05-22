class Test {

   @Factory(dataProvider = "dp")
   public Test(int i) {
      //... some code
   }

   @DataProvider
   public static Object[][] dp(ConstructorOrMethod com) {
       Class<?> testClass = com.getConstructor().getDeclaringClass();
   }

}