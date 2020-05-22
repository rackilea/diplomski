for (int i = 0; i < args.length; i++) {
                BufferedReader reader = new BufferedReader (new FileReader (args[i]));
                List<String> foo = simplify(reader);
                    for (int j = 0; j < foo.size(); j++) {
                        System.out.print(foo.get(j));
                    }
                System.out.println();
            }