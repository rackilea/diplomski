public static void main(String[] args) {
    Observable<Details> dObs = Observable.just(new Details("a", "c"));
    Observable<String> lObs = dObs.map(d -> d.link);
    Observable<String> cObs = dObs.map(d -> d.comments);
    lObs.subscribe(s -> System.out.println(s));
    cObs.subscribe(s -> System.out.println(s));
}


static class Details {
    String link;
    String comments;

    public Details(String link, String comments) {
        this.link = link;
        this.comments = comments;
    }
}