String query = " insert into users (
                        category_questions, 
                        questions, 
                        quest_opt_a, 
                        ,              // empty column name
                        quest_opt_b, 
                        ,              // empty column name
                        quest_opt_c,  
                        quest_opt_d, 
                        correct_option_answer    
                )" + " values (?, ?, ?, ?, ?)"; // you have 7 columns (without the empty ones) but only 5 ?