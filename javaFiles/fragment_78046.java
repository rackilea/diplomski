static <A,B> CList<B> maploop(Func<B,A> f, CList<A> xs){
    Stack<CList<A>> stack = new Stack<>();

    while(xs != null){
        stack.push(xs);
        xs = xs.tail;
    }

    CList<a> result = xs;

    while(!stack.empty()){
        xs = stack.pop();
        result = new CList<>(f.m(xs.head), result);
    }

    return result;
}