MyClass<String> stringMyClass = new MyClass<String>();
stringMyClass.addObserver(new StdoutObserver());

System.out.println("setting changing: true");
stringMyClass.setIsChanging(true);

stringMyClass.add("C");
stringMyClass.add("D");
stringMyClass.add("E");

System.out.println("setting changing: false");
stringMyClass.setIsChanging(false);