@Entity
class Item {
  ...
}

@Entity
class Character {
  ...
  @OneToMany
  ..
  @WhereJoinTable(clause="DTYPE = 'Character'")
  public List<Item> getItems() {
    ...
  }
}

@Entity
class Bank {
  ...
  @OneToMany
  ..
  @WhereJoinTable(clause="DTYPE = 'Bank'")
  public List<Item> getItems() {
    ...
  }
}