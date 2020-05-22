public interface Residence {
  int getNumber();
  Street getStreet();
}

public interface Street {
  City getCity();
}

public interface City {
  Country getAddress();
}