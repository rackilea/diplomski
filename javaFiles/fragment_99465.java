List<Obj> result = list.stream().collect(cumulative((a,b) -> new Obj(b.year,
    a.membercount + b.membercount,
    a.nonmembercount + b.nonmembercount,
    a.memberpayment + b.memberpayment,
    a.nonmemberpayment + b.nonmemberpayment
)));