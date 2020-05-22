interface VerifierA extends VerifierC<VerifierA> {
     VerifierC<VerifierA> method1();
}

interface VerifierB extends VerifierC<VerifierB> {
    VerifierC<VerifierB> method1();
}

interface VerifierC<T> {    
    T commonMethod();
}