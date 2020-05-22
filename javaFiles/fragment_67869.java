while(!ops.isEmpty() && nums.size() > 1)
        {
            String ab = ops.pop();
            double bb = nums.pop();
            double cb = nums.pop();
            double clac = applyOperator(bb,ab,cb);
            nums.add(clac);
        }