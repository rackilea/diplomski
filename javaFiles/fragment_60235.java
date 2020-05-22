if (gc_harm.before(gc_zatr) || (gc_zwol != null && gc_harm.after(gc_zwol)))  //jesli przed zatrudnieniem lub po zwolnieniu
                    {   //wpisz dzien wolny = niekasowalne godziny 'xx - xx' o id = 0
                        listaZapytan[x++] = "insert into tblZmiany (Harmonogram_id, dzien, pracownik_id, godziny_id) "
                                + "values (" + id + ", " + dzien + ", " + prac_id + ", " + 0 + ");";
                        System.out.println(listaZapytan[x-1]);

                    }else{
                        //wpisz zmianę
                        listaZapytan[x++] = "insert into tblZmiany (Harmonogram_id, dzien, pracownik_id, godziny_id) "
                                + "values (" + id + ", " + dzien + ", " + prac_id + ", " + cykl.godziny[offset] + ");";
                        System.out.println("cykl.godziny[" + offset + "] = " + cykl.godziny[offset]);
                        System.out.println(listaZapytan[x-1]);