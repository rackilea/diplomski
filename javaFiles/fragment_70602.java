boolean foundAll = true;
            for (int i = 1; i < args.length && foundAll; ++i) {
                foundAll = foundAll && line.contains(args[i]);
            }
            if (foundAll)
            {
                System.out.println("* " + line);
            }
            else
            {
                System.out.println("  " + line);
            }