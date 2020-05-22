for (int l= 0; l < roll; l++)
  {          
     roll2= (int)(Math.random()*4) + 1;
     o= (int)(Math.random()*100) + 10;   
     p= (int)(Math.random()*100) + 1;        
     if (roll2 == 1)
     {
        if (l < roll)
        {             
           arr[l]= new Rectangle(o, p);
           System.out.println("Rectangle " + rectCount + " stats are: ");
           arr[l].toString();
           rectCount++;
        }
     }
     if (roll2 == 2)
     {    
        if (l < roll)
        {            
           arr[l]= new Square(o);
           System.out.println("Square " + squCount + " stats are: ");
           arr[l].toString();
           squCount++;
        }
     }
     if (roll2 == 3)
     {    
        if (l < roll)
        {
           arr[l]= new rightTriangle(o, p);
           System.out.println("Right triangle " + triCount + " stats are: ");
           arr[l].toString();
           triCount++;
        }
     }
     if (roll2 == 4)
     {
        if (l < roll)
        {            
           arr[l]= new Circle(p);
           System.out.println("Circle " + circCount + " stats are: ");
           arr[l].toString();
           circCount++;
        }
     }      
  }