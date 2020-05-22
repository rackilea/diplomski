public static void validate(final CommandLine cmdLine) {
   final boolean aSupplied = cmdLine.hasOption(A);

   final boolean bAndCSupplied = cmdLine.hasOption(B) && cmdLine.hasOption(C);

   final boolean bOrCSupplied = !bAndCSupplied && (cmdLine.hasOption(B) || cmdLine.hasOption(C));

   if ((aSupplied && bAndCSupplied) || (!aSupplied && !bAndCSupplied)
      || (aSupplied && bOrCSupplied )) {
          throw new Exception(...);
   }
}