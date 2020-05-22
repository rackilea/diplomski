public static void main(String args[]) throws Exception {
    List<String> list = Arrays.asList(
            "-dataFileName ABC.csv -command ii",
            "-dataFileName EFG.csv -command ii",
            "-dataFileName HIJ.csv -command ii",
            "-dataFileName MNPQR.csv -command ii",
            "-dataFileName UVXYZ.csv -command ii"
    );

    list.forEach(x -> {System.out.println(x + " --> " + x.replaceAll("-dataFileName| -command ii", ""));});
}