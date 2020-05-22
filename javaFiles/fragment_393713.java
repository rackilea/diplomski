class Test {
     //implicitly inherits type Object
}

class Quiz extends Test {
     //explicitly inherits type Test
     //implicitly inherits type Object
}

class PopQuiz extends Quiz {
     //explicitly inheirts type Quiz
     //implicitly inheirts type Test and Object
}