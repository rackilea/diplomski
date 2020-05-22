if (!stack.isEmpty() && !isLowerPrecedence(c, stack.peek()))
                {
                    stack.push(c);
                }
                else
                {
                    while (!stack.isEmpty() && isLowerPrecedence(c, stack.peek()))
                    {
                        Character pop = stack.pop();
                        if (pop != '(')
                        {
                            postfix.append(pop);
                        }
                    }
                }

                stack.push(c);