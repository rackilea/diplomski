OCL ocl = OCL.newInstance(new PivotEnvironmentFactory());
OCLHelper helper = ocl.createOCLHelper(EXTLibraryPackage.Literals.LIBRARY);
ExpressionInOCL invariant = helper.createInvariant(
    "books->forAll(b1, b2 | b1 <> b2 implies b1.title <> b2.title)");
ExpressionInOCL query = helper.createQuery(
    "books->collect(b : Book | b.category)->asSet()");

// create a Query to evaluate our query expression
Query queryEval = ocl.createQuery(query);
// create another to check our constraint
Query constraintEval = ocl.createQuery(invariant);

List<Library> libraries = getLibraries();  // hypothetical source of libraries
// only print the set of book categories for valid libraries
for (Library next : libraries) {
   if (constraintEval.check(next)) {
      // the OCL result type of our query expression is Set(BookCategory)
      @SuppressWarnings("unchecked")
      Set<BookCategory> categories = (Set<BookCategory>) queryEval.evaluate(next);

      System.out.printf("%s: %s%n", next.getName(), categories);
   }
}