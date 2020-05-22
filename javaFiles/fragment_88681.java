if (left(node) != null) {
            toStringB(string.append(" ("), left(node));
        }
        if (right(node) != null) {
            toStringB(string.append(", "), right(node));
            string.append(')');
        }