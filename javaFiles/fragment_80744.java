if (!stack.isEmpty()) {
    Stream.iterate(stack.pop(), 
                   e -> !stack.isEmpty(), 
                   e -> stack.pop())
          ...
}