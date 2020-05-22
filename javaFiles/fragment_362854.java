ArrayList<String[]> input = new ArrayList<String[]>();

Scanner sc = new Scanner(new File("input"));

// read the input
while (sc.hasNextLine()) {
    input.add(sc.nextLine().split("\\s"));
}

sc.close();

// this only works if your input isn't jagged!
String[][] mat = new String[input.get(0).length][];

// transform your matrix from [line][column] to [column][line]
for (int i = 0; i < input.size(); i++) {
    for (int j = 0; j < input.get(i).length; j++) {
        if (mat[j] == null) {
            mat[j] = new String[input.size()];
        }
        if (mat[j][i] == null) {
            mat[j][i] = "";
        }
        mat[j][i] += input.get(i)[j];
    }
}

Pattern pattern = Pattern.compile("[A-G]+");
Pattern pattern2 = Pattern.compile("[V]+");

for (int i = 0; i < mat.length; i++) {
    StringBuilder sb = new StringBuilder();
    for (int j = 0; j < mat[i].length; j++) {
        sb.append(mat[i][j]);
    }

    Matcher matcher = pattern.matcher(sb.toString());
    Matcher matcher2 = pattern2.matcher(sb.toString());

    if (matcher.find()) {
        System.out.println("R");
    } else if (matcher2.matches()) {
        System.out.println("Q");
    }
}