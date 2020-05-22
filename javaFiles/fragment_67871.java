else if (prec(tokens [i]) < prec(ops.peek()) && !ops.isEmpty() && ops.peek() != "(")
        {
            ...
            ...
            nums.add(outcome); // I highly suggest refactoring this to nums.push due to readability considerations
            ops.push(tokens[i]);
        }