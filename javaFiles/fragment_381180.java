while(PostfixConversion.precedence(infixExp.charAt(i), stack.peek().charValue()) == false)
            {
                if(stack.peek().charValue() == '(')
                    break;
                postFix += stack.pop().charValue();
            }