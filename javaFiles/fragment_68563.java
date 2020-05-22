enum creditibility {
  excellent, quite_good, medium_ok, could_be_worse, omg
}

struct Pers {
  1: string surname
  2: string firstname
  3: i32 age
}

struct Client {
  1: i32 client_number
  2: string company_name
  3: Pers  contact
  4: creditibility creditibility 
}