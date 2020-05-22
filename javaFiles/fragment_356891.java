Trainer<Cat> catTrainer = (catAction) => catAction(new Cat());

Trainer<Animal> animalTrainer = catTrainer;  
// covariant: Animal > Cat => Trainer<Animal> > Trainer<Cat> 

//define a default training method
Action<Animal> trainAnimal = (animal) => 
   { 
   Console.WriteLine("Training " + animal.GetType().Name + " to ignore you... done!"); 
   };

//work it!
animalTrainer(trainAnimal);