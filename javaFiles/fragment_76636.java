Func<Str,Str> f = and( comsume("a"), consume("b") );
    f.apply("abcd"); // "cd"


Func<Str,Str> consume(String x)
    return input->{ 
        if(input.startsWith(x)) return input.substring(x.length());
        else throws new IllegalArgument()
    };


Func<Str,Str> and(Fun<Str,Str> f1, Func<Str,Str> f2)
    return input-> f2.apply(f1.apply(input))