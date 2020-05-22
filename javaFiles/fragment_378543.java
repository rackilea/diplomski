if( trueCounter % 10 == 0 )
                message += "\n";

            prime = isPrime( number );
            if( prime == true )
            {
                message += " " + number;
                ++trueCounter;
            }