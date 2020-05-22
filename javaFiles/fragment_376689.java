void factors(){

    state = true;
    for (fact = 2; fact < Number; fact++){
        if (fact != Number){
            if (Number % fact == 0){
                state = false;
                break;
            }
        }
    }
    if (state == true){
        System.out.println(Number);
    }

}