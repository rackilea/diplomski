int time = 60; // get time from your function 0-99
int textField1 = (int) time/10; // takes a number, forces it to be int after
                                // dividing by ten (ex: 65/10 = 6.5 -> 6)
int textField2 = (int) time - (textField1 * 10); // finds the first place digit
                                                 // by making it subtract the second place
                                                 // (ex: 65 - (6*10) = 5)