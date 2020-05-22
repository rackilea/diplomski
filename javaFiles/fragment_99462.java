public class Obj {
    String year;
    Long membercount;
    Long nonmembercount;
    Double memberpayment;
    Double nonmemberpayment;

    public Obj(String year, long membercount, long nonmembercount,
            double memberpayment, double nonmemberpayment) {
        this.year = year;
        this.membercount = membercount;
        this.nonmembercount = nonmembercount;
        this.memberpayment = memberpayment;
        this.nonmemberpayment = nonmemberpayment;
    }

    @Override
    public String toString() {
        return "Obj("+year+", "+membercount+", "+nonmembercount
            +", "+memberpayment+", "+nonmemberpayment+')';
    }
}