@Service //stateless spring service singleton
class MyService {
ResultVO theRun(int iterations) {  // actual execution method
    do();
    some();
    subroutines();
    if (validationFails() && iterations <= 3) { 
        theRun(iterations+1); //retry the iteration steps only 3 times
    } else {
        throw TooManyIterationsException();
    }
    doSomethingWithIterations(iterations);
    return resultVO;
}


    ResultVO run() {   // same name stub as before
       return theRun(0);
    }


}