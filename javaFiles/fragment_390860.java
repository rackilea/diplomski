package de.scrum_master.stackoverflow

import groovy.transform.ToString
import spock.lang.Specification

class ListMatchTest extends Specification {
  static girlsNames = [
    "Emma", "Hannah", "Mia", "Sofia", "Emilia", "Lina", "Anna", "Marie", "Mila", "Lea", "Leni", "Clara", "Lena", "Luisa", "Leonie", "Amelie", "Emily", "Johanna", "Ella", "Nele", "Sophie", "Charlotte", "Ida", "Lilly", "Laura", "Maja", "Mathilda", "Lara", "Frieda", "Lia", "Greta", "Lotta", "Sarah", "Melina", "Paula", "Julia", "Marlene", "Pia", "Alina", "Nora", "Elisa", "Victoria", "Mira", "Lisa", "Isabella", "Anni", "Juna", "Isabell", "Zoe", "Mara", "Luna", "Luise", "Finja", "Maria", "Josephine", "Pauline", "Romy", "Theresa", "Merle", "Antonia", "Elena", "Helena", "Paulina", "Eva", "Magdalena", "Jana", "Elli", "Katharina", "Emely", "Fiona", "Martha", "Lucy", "Stella", "Thea", "Annabell", "Amy", "Tilda", "Mina", "Elina", "Jasmin", "Carla", "Annika", "Alessia", "Jule", "Rosalie", "Malia", "Carlotta", "Elisabeth", "Maila", "Valentina", "Milena", "Nina", "Ronja", "Melissa", "Chiara", "Hailey", "Olivia", "Amelia", "Amalia", "Franziska", "Lotte", "Miriam", "Luana", "Zoey", "Linda", "Elif", "Leila", "Emmi", "Mariella", "Aaliyah", "Ela", "Selina", "Sina", "Anastasia", "Vanessa", "Tessa", "Helene", "Liana", "Aurelia", "Ava", "Lynn", "Kira", "Marleen", "Rosa", "Alma", "Carolin", "Diana", "Alicia", "Alexandra", "Jette", "Lene", "Lenja", "Marla", "Milla", "Freya", "Aurora", "Elsa", "Amira", "Malina", "Aylin", "Lucia", "Ylvi", "Enna", "Lana", "Carolina", "Jara", "Liv", "Amina", "Joleen", "Elise", "Liya", "Leticia", "Mathea", "Giulia", "Jolina", "Rebecca", "Alisa", "Edda", "Evelyn", "Laila", "Mona", "Svea", "Celine", "Julie", "Liliana", "Milana", "Vivien", "Tabea", "Cataleya", "Talia", "Livia", "Daria", "Noemi", "Alissa", "Ariana", "Annalena", "Miray", "Carina", "Leana", "Melia", "Veronika", "Melek", "Zeynep", "Bella", "Alice", "Maira", "Celina", "Annelie", "Henriette", "Jonna", "Christina", "Fabienne", "Nela", "Amilia", "Linea", "Nelly", "Felicitas", "Medina", "Michelle", "Natalie", "Samira", "Anne", "Alena", "Angelina", "Leona", "Rieke", "Alea", "Dana", "Larissa", "Selma", "Valerie", "Xenia", "Lou", "Marina", "Tamara", "Marlena", "Heidi", "Lorena", "Helen", "Hermine", "Joline", "Malea", "Dilara", "Enie", "Azra", "Defne", "Ina", "Kate", "Meryem", "Nisa", "Josie", "Madita", "Florentine", "Mariam", "Elea", "Eliana", "Hedi", "Nika", "Enya", "Valeria", "Eleni", "Fenja", "Holly", "Levke", "Malin", "Flora", "Leandra", "Palina", "Tamina", "Ayla", "Leia", "Lieselotte", "Hira", "Jessika", "Nala", "Nicole", "Alia", "Elin", "Malou", "Alexa", "Aleyna", "Estelle", "Kim", "Cara", "Melody", "Esila", "Josefin", "Sunny", "Felicia", "Käthe", "Liesbeth", "Lilia", "Ruby", "Selin", "Smilla", "Felina", "Mailin", "Adriana", "Eleonora", "Fritzi", "Kaja", "Lola", "Fatima", "Juliana", "Tara", "Madlen", "Samantha", "Delia", "Lilith", "Naila", "Aria", "Arina", "Lilian", "Miley", "Tuana", "Amara", "Asya", "Eda", "Hilda", "Jolie", "Kimberly", "Viola", "Alva", "Ellen", "Marit", "Fine", "Liara", "Mathilde", "Melisa", "Felia", "Liz", "Talea", "Arya", "Cecilia", "Clea", "Esma", "Janne", "Sonja", "Adelina", "Alexia", "Helin", "Melinda", "Wilma", "Gloria", "Grace", "Josephina", "Lenia", "Mary", "Patricia", "Amanda", "Esther", "Friederike", "Juliane", "Leonora", "Marieke", "Naomi", "Zara", "Dalia", "Malena", "Melanie", "Natalia", "Romina", "Tina", "Alya", "Hedda", "Joana", "Maike", "Philippa", "Claire", "Enni", "Eylül", "Inga", "Luzi", "Nila", "Shirin", "Soraya", "Alara", "Jasmina", "Maileen", "Marisa", "Nike", "Philine", "Salome", "Zehra", "Zuzanna", "Alisha", "Anja", "Ashley", "Bianca", "Ecrin", "Erna", "Evelina", "Charlotta", "Cleo", "Eliza", "Feline", "Jella", "Jill", "Madeleine", "Naemi", "Ria", "Sena", "Skadi", "Anisa", "Elaine", "Eleanor", "Ilayda", "Janina", "Judith", "Katja", "Lydia", "Melis", "Neyla", "Tiana", "Ada", "Alica", "Anouk", "Evi", "Henrieke", "Verena", "Abby", "Cassandra", "Ceylin", "Eslem", "Ivy", "Janna", "Lani", "Mieke", "Mika", "Annemarie", "Iva", "Jenna", "Maren", "Nadia", "Penelope", "Violetta", "Betty", "Elis", "Giuliana", "Irma", "Jolien", "Lavin", "Rita", "Adele", "Alessa", "Hazal", "Jamila", "Jolene", "Julina", "Kiana", "Margarete", "Maxi", "Meta", "Noelia", "Rahel", "Svenja", "Almira", "Anita", "Ann", "Asmin", "Elissa", "Erika", "Lilou", "Line", "Runa", "Ruth", "Saskia", "Simay", "Stina", "Ylva", "Zümra", "Ceyda", "Cora", "Elenor", "Jennifer", "Joy", "Leonore", "Liyana", "Malak", "Megan", "Minna", "Selena", "Sila", "Abigail", "Arin", "Clarissa", "Darina", "Femke", "Frederike", "Lorin", "Luca", "Luzia", "Nia", "Phoebe", "Rafaela", "Rana", "Charlie", "Debora", "Erva", "Esra", "Franka", "Jona", "Lisann", "Marielle", "Nelia", "Nour", "Nova", "Sandra", "Stefanie", "Theresia", "Toni", "Vera", "Yaren", "Amber", "Cheyenne", "Chloe", "Daniela", "Florentina", "Gabriela", "Hanne"
  ]

  @ToString(includePackage = false)
  static class Employee {
    int id
    String name
    double salary
  }

  static lastId = 0
  static employees = girlsNames.collect {
    new Employee(id: ++lastId, name: it, salary: 100 * (lastId % 13 + 1))
  }

  def "Employee with ID 100 and salary > 900 exists"() {
    expect:
    employees.any { it.id == 100 && it.salary > 900 }
  }

  def "There are at least 70 employees with salaries >= 1111"() {
    expect:
    employees.count { it.salary >= 1111 } >= 70
  }

  def "Employee Marie is unique"() {
    expect:
    employees.count { it.name == "Marie" } == 1
  }

  def "Field 'id' is a unique key"() {
    expect:
    employees.collect { it.id }.toSet().size() == employees.size()
  }

  def "Field 'salary' is not unique"() {
    expect:
    employees.collect { it.salary }.toSet().size() != employees.size()
  }
}