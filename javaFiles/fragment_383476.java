public class Polynomial {
public static void main(String[] args) {
    Polynomial p1 = new Polynomial();
    Polynomial p2 = new Polynomial();
    Polynomial p0 = new Polynomial();
    p1.addTerm(1, 2);
    p1.addTerm(1, 4);
    p1.addTerm(1, 6);
    p2.addTerm(1, 1);
    p2.addTerm(2, 3);
    p2.addTerm(2, 2);
    p2.addTerm(1, 5);
    System.out.println("p1 = " + p1.toString());
    System.out.println("p2 = " + p2.toString());

    System.out.println("Adding p1 to p2...");
    p0 = p1.addPolynomial(p2);
    System.out.println(p0.toString());

    for(int i = 0;i < 100;i++) {
        p1 = new Polynomial();
        p2 = new Polynomial();
        for(int j = 0;j < 4;j++) {
            p1.addTerm((int) (10 * Math.random()) - 5,
                    (int) (4 * Math.random()));
            p2.addTerm((int) (10 * Math.random()) - 5,
                    (int) (4 * Math.random()));
        }
        p0 = p1.addPolynomial(p2);
        System.out.println(p1 + "\n" + p2 + "\n" + p0 + "\n");
    }
}



enum Comp {
    LT, EQ, GT
}


static Comp cmp(int a, int b) {
    return (a < b) ? Comp.LT : (a == b) ? Comp.EQ : Comp.GT;
}

private Term poly;


public Polynomial() {
    poly = null;
}


public void addTerm(int coef, int exp) {
    if (coef == 0) return;
    Term term = new Term(coef, exp,null);
    if (poly == null) {
        poly = term;
    } else {
        poly = poly.add(term);
    }
}


@Override
public String toString() {
    if (poly == null) return "0";

    StringBuilder buf = new StringBuilder();
    poly.writeTo(buf);
    return buf.toString();
}


public Polynomial addPolynomial(Polynomial that) {
    Polynomial ret = new Polynomial();
    if (poly != null) {
        ret.poly = new Term(poly);
        if (that.poly != null) {
            ret.poly = ret.poly.add(new Term(that.poly));
        }
    } else if (that.poly != null) {
        ret.poly = new Term(that.poly);
    }
    return ret;
}


private class Term {
    final int coef;

    final int exp;

    final Term next;


    Term(int coef, int exp, Term next) {
        this.coef = coef;
        this.exp = exp;
        this.next = next;
    }


    Term(Term copy) {
        this.coef = copy.coef;
        this.exp = copy.exp;
        if (copy.next == null) {
            this.next = null;
        } else {
            this.next = new Term(copy.next);
        }
    }


    Term add(Term other) {
        if (other == null) return this;

        switch (cmp(this.exp, other.exp)) {
        case LT: {
            Term n = other.add(this);
            return n;
        }
        case GT: {
            if (next == null) {
                return new Term(coef,exp,other);
            }

            return new Term(coef,exp,next.add(other));
        }
        default: {
            Term n = (next==null) ? other.next : next.add(other.next);
            int nc = coef+other.coef;
            return (nc!=0) ? new Term(nc,exp,n) : n;
        }
        }
    }


    public void writeTo(StringBuilder app) {
        if (coef != 1 || exp == 0) app.append(coef);
        if (exp == 1) {
            app.append("x");
        } else if (exp != 0) {
            app.append("x^").append(exp);
        }
        if (next != null) {
            app.append('+');
            next.writeTo(app);
        }
    }
}
}