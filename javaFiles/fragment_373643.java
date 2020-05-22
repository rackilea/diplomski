public static void main(String[] args) {
    Observable<Integer> xs = Observable.range(1, 8);

    Func1<Integer, Boolean> predicate = new Func1<Integer, Boolean>() {
        @Override
        public Boolean call(Integer x) {
            return x % 2 == 0;
        }
    };

    Action1<Integer> action = new Action1<Integer>() {
        @Override
        public void call(Integer x) {
            System.out.println("> " + x);
        }
    };

    xs.lift(new FilterAndTake<Integer>(predicate, 2)).subscribe(action);
}