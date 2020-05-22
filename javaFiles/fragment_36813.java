String s = "M-T-D-S-F1-F2";
def m = s =~ /\bF1\b/;
if (m.count > 1) {
    println("FAIL!");
} else {
    println("VALID");
}