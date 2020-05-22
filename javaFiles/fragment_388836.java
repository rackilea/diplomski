IJavaElement[] allPackagesToSearch = ...
SearchRequestor requestor = <implement the SearchRequestor abstract class and store all matches>

IJavaSearchScope scope= SearchEngine.createJavaSearchScope(binaryPackages, IJavaSearchScope.APPLICATION_LIBRARIES);
int matchRule= SearchPattern.R_EXACT_MATCH | SearchPattern.R_CASE_SENSITIVE;
SearchPattern runWithPattern= SearchPattern.createPattern("com.foo.MyAnnotation", IJavaSearchConstants.ANNOTATION_TYPE, IJavaSearchConstants.ANNOTATION_TYPE_REFERENCE, matchRule);
SearchParticipant[] searchParticipants= new SearchParticipant[] { SearchEngine.getDefaultSearchParticipant() };
new SearchEngine().search(annotationsPattern, searchParticipants, scope, requestor, new SubProgressMonitor(pm, 2));