else
            {
                greedySearch (smallestNode); // Resuming from here...
            }
        }
        else
        {
            // ...all this is skipped (because we are in the else block
            // of an if that was true)...
        }
        // ...and this is printed.
        System.out.println("This will not print");      
    }