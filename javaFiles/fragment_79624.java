for(int i=0; i < stats.length; i = i + 1) {
        if ( i <= stats.length - 3) {
            try {
                System.out.print(Integer.parseInt(stats[i][1]) + ", ");
            } catch(NumberFormatException ignore){/* ignore this */}
        }
        else {
            try {
                System.out.println(Integer.parseInt(stats[i][1]) + ", ");
            } catch(NumberFormatException ignore){/* ignore this */}
        }
    }