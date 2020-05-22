FatherDocument fatherDocument = FatherDocument.Factory.newInstance();
Father father = fatherDocument.addNewFather();
Son son = father.addNewSon();
son.setTarget("Some string");
StringWriter writer = new StringWriter();
fatherDocument.save(writer);
System.out.println(writer.toString());