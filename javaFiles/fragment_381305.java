public static void main(String[] args) {

    Double cubed = 0d;
    Double answer = 0d;

    while (cubed.compareTo(3d) <0) {
        answer ++;
        cubed = Math.log( answer )/Math.log( 4 );
        System.out.println(cubed + "   " + answer);
    }

    double answer_for_cubed = answer;
    System.out.println("answer_for_cubed  " + answer_for_cubed);
}