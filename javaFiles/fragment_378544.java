prime = isPrime( number );
            if( prime == true )
            {
                message += " " + number;
                ++trueCounter;

                if( trueCounter % 10 == 0 )
                    message += "\n";
            }