boolean cleanupfirst = false;

            try {
                op1 ();
                cleanupfirst = true;
                op2 ();
                cleanupfirst = false;
                op3 ();
            } catch (Exception e) {
                if (cleanupfirst)
                    cleanup ();
                return;
            }