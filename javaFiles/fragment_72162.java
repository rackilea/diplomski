long num1 = 100120000;  // 10.012   => true
                        // 100120000 % 10000 is 0 = valid
long num2 = 102211000;  // 10.2211  => false
                        // 102211000 % 10000 is 1000 = invalid
long num3 = 102000000;  // 10.2     => true
                        // 102000000 % 10000 is 0 = valid