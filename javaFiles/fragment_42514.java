// opening (
if (in_fix.peek().type == 4) {   
    post_fix.push(in_fix.pop());
}
//closing )
if(in_fix.peek().type == 5){
    while(!(post_fix.isEmpty() || post_fix.peek().type == 4)){
         postfixstr.append(post_fix.pop());
    }
    if (post_fix.isEmpty())
        ; // ERROR - unmatched )
    else
        post_fix.pop(); // pop the (
    in_fix.pop(); // pop the )
}