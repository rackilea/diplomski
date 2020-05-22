//Instantiation 
Enterprise[] en = new Enterprise[20];//the number of iterations you need

//You do not have a default constructor, so I would use this to add the "int index"
en[i] = new Enterprise(X); //For each enterprise where "X" is a number for the "int index"


//in the loop
en[i].setName(scanner.next());