for (int i = 0; i < in.length; i++)
        switch (in[i]) {
        case '+':
        case '-':
            while (!stack.empty() && (stack.peek() == '*' || stack.peek() == '/')) {
                out.append(' ');
                out.append(stack.pop());
            }
            out.append(' ');
            stack.push(in[i]);
            break;
        case '*':
        case '/':
            out.append(' ');
            stack.push(in[i]);
            break;
        case '(':
            stack.push(in[i]);
            break;
        case ')':
            while (!stack.empty() && stack.peek() != '(') {
                out.append(' ');
                out.append(stack.pop());
            }
            stack.pop();
            break;
        default:
            out.append(in[i]);
            break;
        }