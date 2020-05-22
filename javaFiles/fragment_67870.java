else if (prec(tokens [i]) < prec(ops.peek()) && !ops.isEmpty() && ops.peek() != "(")
        {
            String ac1 = ops.pop();
            double res1 = nums.pop();
            double res2 = nums.pop();
            double outcome = applyOperator(res1,ac1,res2);
            nums.add(outcome);
        }