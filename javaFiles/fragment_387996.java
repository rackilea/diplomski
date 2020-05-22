Processor<PsiClass> processor = new Processor<PsiClass>() {
    @Override
    public boolean process(PsiClass psiClass) {
        // do your actual work here
        return true;
    }
};

AllClassesGetter.processJavaClasses(
        new PlainPrefixMatcher(""),
        project,
        GlobalSearchScope.projectScope(project),
        processor
);