// usings aspects to remove cross-cutting concerns from the model and follow SRP
@DatabaseSerializable 
Car {
   // rich domain model encapsulates engine state and exposes behavior
   drive();            
}