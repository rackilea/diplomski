for(int i=0; i < stats.length; i = i + 1) {
        if ( i <= stats.length - 3) {
            stats[i][1] = (stats[i][1]);
            System.out.print(stats[i][1] + ", ");
        }
        else System.out.println(stats[i][1]);
    }