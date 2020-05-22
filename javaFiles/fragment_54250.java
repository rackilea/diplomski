private static class Postfix {
    class Operation {  // internal class
       Operation lhs;
       Operation rhs;
       char operator;
       char varname;
       boolean shouldParens = false;

       Operation( Operation l, char operator, Operation r ) {
          this.lhs = l;
          this.rhs = r;
          this.operator = operator;
       }

       Operation( char name ) {
          this.varname = name;
       }

       public void addParensIfShould( char newop ) {
          if ( !varname ) {
              if ( newop == '~' ) {
                 this.shouldParens = true;
              }
              else if ( newop == '*' || newop == '/' ) {
                 if ( this.operator == '+' || this.operator == '-' ) {
                    this.shouldParens = true;
                 }
              }
          }
       }

       public String toString() {
          if ( varname ) return "" + varname;
          StringBuilder b = new StringBuilder();
          if ( shouldParens ) b.append("(");
          if ( lhs ) { b.append( lhs.toString() ); }
          b.append( operator );
          if ( rhs ) { b.append( rhs.toString() ); }
          if ( shouldParens ) b.append(")");
          return b.toString()
       }
    };

    private void convert(String postfix) {
        Stack<Operation> s = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char o = postfix.charAt(i);
            if (isOperator(o)) {
                if (o == '~') {
                    Operation a = s.pop();
                    a.addParensIfShould( o );
                    Operation newOp = new Operation( null, o, a );
                    System.out.println( "Adding uni op " + newOp )
                    s.push(newOp);
                }
                else {
                    Operation b = s.pop();
                    Operation a = s.pop();
                    a.addParensIfShould( o );
                    b.addParensIfShould( o );
                    Operation newOp = new Operation( a, o, b );
                    System.out.println( "Adding bi op " + newOp )
                    s.push(newOp);
                }
            } else {
                Operation newOp = new Operation( o ); // it's just a varname
                System.out.println( "Adding varname op " + newOp )
                s.push(newOp);    
            }
        }
        System.out.println "<INF>" + s.toString()
    }
}