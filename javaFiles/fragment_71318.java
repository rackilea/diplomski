int result = tempA - tempB - carry;
            carry = result < 0 ? 1 : 0;
            result += 10*carry;
            int resultDigit = result % 10;

            resultStack.push(resultDigit);


    if (carry > 0)
    {
        resultStack.push(10 - carry); // Negative number actually
    }