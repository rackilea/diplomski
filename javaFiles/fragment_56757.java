public class AnnotationFilter<T> {
    private Class filterAnno;

    public AnnotationFilter(Class a) {
        filterAnno = a;
    }

    public List<T> filter(List<T> inputList) {
        if (inputList == null || inputList.isEmpty()) {
            return inputList;
        }
        List<T> filteredList = new ArrayList<T>();
        for (T someT : inputList) {
            if (someT.getClass().isAnnotationPresent(filterAnno)) {
                filteredList.add(someT);
            }
        }
        return filteredList;
    }
}