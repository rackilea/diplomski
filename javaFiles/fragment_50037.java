CombiParentheses(2, 0, str):
    CombiParentheses(1, 1, str.Append("(")):
        CombiParentheses(0, 2, str.Append("(")):
            CombiParentheses(0, 1, str.Append(")")):
                CombiParentheses(0, 0, str.Append(")")); // StringBuilder was reset here!
        CombiParentheses(1, 0, str.Append(")")):
            CombiParentheses(0, 1, str.Append("(")):
                CombiParentheses(0, 0, str.Append(")"));