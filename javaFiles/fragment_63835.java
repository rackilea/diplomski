result = Double.valueOf(values.get(0)); // Get first, so 'result != 0'
for (int i = 1; i < values.size(); i++) {
    double val = Double.valueOf(values.get(i).toString());
    switch(operator)  {
        case '+':
            result += val;
            break;
        case '-':
            result -= val;
            break;