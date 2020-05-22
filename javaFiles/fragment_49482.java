abstract class RequestData<E> {

    abstract void add(E newRequest);

    abstract List<E> getRequests();

    abstract List<E> getFulfilledRequests();

    abstract List<E> getUnfulfilledRequests();

    abstract void printRequests();

    abstract void printFulfilledRequests();

    abstract void printUnfulfilledRequests();

    protected void print(String listTitle, List<E> listToPrint) {
        StringBuilder string = new StringBuilder();
        string.append(listTitle);

        for (E request : listToPrint) {
            string.append("\n").append(request);
        }

        System.out.println(string);
    }

}