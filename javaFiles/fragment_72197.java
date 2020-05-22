double a, b;
Scanner s = new Scanner(System.in);
System.out.println("Please enter marks:");
a = s.nextDouble();
b = s.nextDouble();

Instance inst = new DenseInstance(3); 

inst.setValue(COMS1000, a); 
inst.setValue(MATH1001, b); 
inst.setClassMissing();

inst.setDataset(source); 

double pred = tree.classifyInstance(inst);
System.out.println(pred.value(Double.toString(pred)));