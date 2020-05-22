int a = 323, b = 322;

java.util.Stack<Integer> stack = new java.util.Stack<>();

int n = a + b;
while (n > 0) {
    stack.push(n % 10);
    n = n / 10;
}

while (!stack.isEmpty())
    System.out.println(stack.pop());