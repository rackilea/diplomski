if (gc_harm.before(gc_zatr) || (gc_zwol != null && gc_harm.after(gc_zwol)))  //jesli przed zatrudnieniem lub po zwolnieniu
                {   //wpisz dzien wolny = niekasowalne godziny 'xx - xx' o id = 0
                    stat.executeUpdate("insert into tblZmiany (Harmonogram_id, dzien, pracownik_id, godziny_id) "
                            + "values (" + id + ", " + dzien + ", " + prac_id + ", " + 0 + ");");
                }else{
                    //wpisz zmianę
                    stat.executeUpdate("insert into tblZmiany (Harmonogram_id, dzien, pracownik_id, godziny_id) "
                            + "values (" + id + ", " + dzien + ", " + prac_id + ", " + cykl.godziny[offset] + ");");
                }