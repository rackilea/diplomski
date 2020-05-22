public static <T> T dualFold(List<T> l, BinaryOperator<T> f1, BinaryOperator<T> f2) {
    List<T> resF1 = new ArrayList<>(); //calculate result of f1 for each pair

    for (int i = 0; i < l.size(); i += 2) {
        resF1.add(f1.apply(l.get(i), l.get(i + 1)));
    }

    T ans = f2.apply(resF1.get(0), resF1.get(1)); //get initial value of ans

    for (int i = 2; i < resF1.size(); i++) {
        ans = f2.apply(ans, resF1.get(i)); //successively evaluate from left to right
    }

    ans = f2.apply(ans, l.get(l.size() - 1)); //don't forget about the last term of expr

    return ans;
}