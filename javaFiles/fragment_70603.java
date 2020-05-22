boolean foundAny = false;
            for (int i = 1; i < args.length; ++i) {
                foundAny = line.contains(args[i]);
                if (foundAny) break;
            }
            if (foundAny)
            {
                System.out.println("* " + line);
            }
            else
            {
                System.out.println("  " + line);
            }