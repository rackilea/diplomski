for (int j = 0; j < n - i - 1; j++) {
            if (a[j] > a[j + 1]) {
                temp = a[j];
                a[j] = a[j + 1];
                a[j + 1] = temp;

                // Sort them according to their name
                temps = name[j];
                name[j] = name[j + 1];
                name[j + 1] = temps;
            }else if(a[j] == a[j + 1]){
                int result = name[j].compareTo(name[j + 1]);
                if(result < 0){
                    temps = name[j];
                    name[j] = name[j + 1];
                    name[j + 1] = temps;
                }
            }
        }