FruitVisitorWasher fvw = new FruitVisitorWasher() ;

for( Fruit f: arguments)
{
   f.accept(fvw) ;
}