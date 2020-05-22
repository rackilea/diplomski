visit(ast){ 
    case \if(icond,ithen,ielse): {
        println(" if-then-else statement with condition <icond> found"); } 
    case \if(icond,ithen): {
        println(" if-then statement with condition <icond> found"); } 
};