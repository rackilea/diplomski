public static String arrayToString(double[][] dblArray) {
        StringBuilder fin = new StringBuilder();
        for (double[] d : dblArray){
            fin.append(Arrays.toString(d).replace("[", "").replace("]", "").replace(",", " ") + "\n");
        }
        return fin.toString();
    }