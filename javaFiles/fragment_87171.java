String kek = "Guardians Of the Galaxy(G.T .G . V)";
int fInd = kek.indexOf("(") + 1;
int lInd = kek.indexOf(")");
String kek1 = kek.substring(fInd, lInd);
String kek2 = kek1.replace(".", "").replace(" ", "");
Toast.makeText(getApplicationContext(), kek2, Toast.LENGTH_SHORT)
            .show();