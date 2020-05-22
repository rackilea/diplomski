Object rhs = stack.pop();
Object lhs = stack.pop();
TypeCasted casted = operator.typeCast(lhs, rhs);
lhs = casted.lhs;
rhs = casted.rhs;
stack.push(operator.eval(lhs, rhs));