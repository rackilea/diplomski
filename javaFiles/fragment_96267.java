String input = "Foo {{Infobox musical artist\n"
                + "|honorific-prefix  = [[The Honourable]]\n"
                + "| name = Bob Marley\n"
                + "| image = Bob-Marley.jpg\n"
                + "| alt = Black and white image of Bob Marley on stage with a guitar\n"
                + "| caption = Bob Marley in concert, 1980.\n"
                + "| background = solo_singer\n"
                + "| birth_name = Robert Nesta Marley\n"
                + "| alias = Tuff Gong\n"
                + "| birth_date = {{birth date|df=yes|1945|2|6}}\n"
                + "| birth_place = [[Nine Mile, Jamaica|Nine Mile]], [[Jamaica]]\n"
                + "| death_date = {{death date and age|df=yes|1981|5|11|1945|2|6}}\n"
                + "| death_place = [[Miami]], [[Florida]]\n"
                + "| instrument = Vocals, guitar, percussion\n"
                + "| genre = [[Reggae]], [[ska]], [[rocksteady]]\n"
                + "| occupation = [[Singer-songwriter]], [[musician]], [[guitarist]] \n"
                + "| years_active = 1962–1981\n"
                + "| label = [[Beverley's]], [[Studio One (record label)|Studio One]],\n"
                + "| associated_acts = [[Bob Marley and the Wailers]]\n"
                + "| website = {{URL|bobmarley.com}}\n" + "}} Bar";
//                                    |DOTALL flag
//                                    |  |first two curly brackets
//                                    |  |     |multi-line dot
//                                    |  |     | |last two curly brackets
//                                    |  |     | |        | replace with empty
System.out.println(input.replaceAll("(?s)\\{\\{.+\\}\\}", ""));