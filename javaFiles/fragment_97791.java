String formula = "Ab((3.0)*(2.5))";
StringBuilder builder = new StringBuilder();
for (int i = 0; i < formula.length(); i++){
    char c = formula.charAt(i);
    if(Character.isLetter(c)) {
        builder.append(" "+c+" ");
    } else {
        builder.append(c);
    }
}