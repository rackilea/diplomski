// Take a copy of current.
            SLLNode temp = current;
            // Step to next.
            current=current.succ;
            // Point temp (old current) to new next <----- Added this.
            temp.succ = current.succ;
            // Point next's successor to current.
            current.succ=temp;
            // Remember to check again.
            check = true;