String[] tokens = eqn.split(" ");
int result = Integer.parseInt(tokens[0]);
for (int t = 1; t < tokens.length; t += 2) {
  Op op = new Op(
      result,
      result, tokens[t].charAt(0), 
      Integer.parseInt(tokens[t+1]));
  Thread t = new Thread(op);
  t.start();
  t.join();    
  result = op.result;
}