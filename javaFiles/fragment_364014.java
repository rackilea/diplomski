class QuestionableConstruct {
    int sum;
    QuestionableConstruct add(int num2) {
        sum += num2;
        return this;
    }
}
Runnable fn19 = () -> {
    IntFunction<QuestionableConstruct> addNum = num -> {
        QuestionableConstruct fn = new QuestionableConstruct();
        fn.sum = num;   
        return fn;
    };
    System.out.println("addNum(3)(4)(3)(10)==> "+addNum.apply(3).add(4).add(3).add(10).sum);
};
fn19.run();