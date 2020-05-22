while (scan.hasNext()) {             //read file to string and split it
            String str = scan.nextLine();
            String[] arr = str.split(",");

            int n = Integer.parseInt(arr[3]);
            int m = Integer.parseInt(arr[4]);
            Team tm = new Team(arr[0], arr[1], arr[2], n, m);
            group.add(tm);

        }