interface Operation {
  int eval(int a, int b);
}

class Addition {
  int eval(int a, int b) { return a + b; }
}

class Subtraction {
  int eval(int a, int b) { return a - b; }
}

...

Operation[] operations = new Operation[]{new Addition(), new Subtraction(), ..};

int executeRandom(int a, int b) {
  return operations[random.nextInt(operations.length)].eval(a,b);
}