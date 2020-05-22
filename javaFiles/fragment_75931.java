public class Engineer {
    public void do() {
        System.out.println("I build stuff");
    }
}

public class ElectricalEngineer {
    public void do() {
        System.out.println("I build electronics");
    }
}

public class ComputerEngineer {
    public void do() {
        System.out.println("I build computers");
    }
}

Engineer eng = new Engineer();
ElectricalEngineer ee = new ElectricalEngineer();
ComputerEngineer ce = new ComputerEngineer();

eng.do(); // prints "I build stuff"
ee.do(); // prints "I build electronics"
ce.do(); // prints "I build computers"

// eng is of type Engineer
// ee is of type ElectricalEngineer
// ce is of type ComputerEngineer

Engineer ee2 = new ElectricalEngineer();
Engineer ce2 = new ComputerEngineer();

ee2.do(); // prints "I build electronics"
ce2.do(); // prints "I build computers"