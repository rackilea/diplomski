Object[] pokemon = {new Bulbasaur(), new Ivysaur(), new Venusaur()}; // etc. etc.

int answer = Integer.parseInt(reader.nextLine());
answer = answer - 1; // because arrays start at zero, not one

System.out.println("\nPokemon: " + pokemon[answer].getname() +     
"\nType: " + pokemon[answer].getthing_about() +
"\nHealth: " + pokemon[answer].gethp() +
"\nAttack: " + pokemon[answer].getattack() +
"\nDefense: " + pokemon[answer].getdefense() +      
"\nSpecial attack: " + pokemon[answer].getspattack() +        
"\nSpecial defense: " + pokemon[answer].getspdefense()+ 
"\nSpeed: " + pokemon[answer].getspeed() +
"\nTotal: " + pokemon[answer].gettotal());