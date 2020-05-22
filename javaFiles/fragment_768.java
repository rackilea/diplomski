String owner = read.next();
Veterinarian work = new Veterinarian(petname, birthday, species, bill, owner);
Veterinarian.Vet.add(work); // once

...

public Veterinarian(String petname, int birthday, String species, double bill, String owner){
    this.petname = petname;
    this.birthday = birthday;
    this.species = species;
    this.bill = bill;
    this.owner = owner;
    Vet.add(this); // twice
}