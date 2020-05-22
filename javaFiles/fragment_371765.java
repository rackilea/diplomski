for(int i = 0; i < fruit.length; i++) {   

    PVector seek = fruit[i].attractAnimal(animal[i]);
    // this line and the previous for i = 1
    animal[i].gatherFood(seek);


    fruit[i].display();

  }