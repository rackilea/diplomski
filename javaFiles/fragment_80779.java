private static MatchingMethod findBestMethod(List methods, Class typeClass, String name, Class[] argClasses) {
    MatchingMethod mm = null;
    IllegalArgumentException failure = null;
    for (int i = 0, icount = methods.size(); i < icount; i++) {
        // ...

        if (mm == null || mm.score > score) {
            mm = new MatchingMethod(m, score, report, mParameterTypes);
            failure = null;
        } else if (mm.score == score) {
            if (Arrays.equals(mm.mMethod.getParameterTypes(), m.getParameterTypes()) && mm.mMethod.getName().equals(m.getName())) {
                if (mm.mMethod.getDeclaringClass().isAssignableFrom(m.getDeclaringClass())) {
                    if (!retsAreEqual && !mm.mMethod.getReturnType().isAssignableFrom(m.getReturnType()))
                        System.err.println("Two methods with same method signature but return types conflict? \""+mm.mMethod+"\" and \""+m+"\" please report!");

                    mm = new MatchingMethod(m, score, report, mParameterTypes);
                    failure = null;
                } else if (!m.getDeclaringClass().isAssignableFrom(mm.mMethod.getDeclaringClass())) {
                    // this should't happen
                    System.err.println("Two methods with same method signature but not providing classes assignable? \""+mm.mMethod+"\" and \""+m+"\" please report!");
                } else if (!retsAreEqual && !m.getReturnType().isAssignableFrom(mm.mMethod.getReturnType()))
                    System.err.println("Two methods with same method signature but return types conflict? \""+mm.mMethod+"\" and \""+m+"\" please report!");
            } else {
                // ... cut out
            }
        }
    }
    if (failure != null)
        throw failure;
    return mm;
}