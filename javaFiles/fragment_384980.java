for(int i = 0; i < input.length() - 1; i++){
    if(input.charAt(i) == '=') {
        if(input.charAt(i + 1) == '=') {
            System.out.println("Comparison Operator");
        }
        else {
            System.out.println("Assignment Operator");
        }
        break;
    }
}