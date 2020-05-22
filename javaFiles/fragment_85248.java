public class GenerateTestSets {
 private final int questionCat;
 private final int setNo;
 private int[] selectedGroups;
 private final int groupDelta;


public GenerateTestSets(final int questionCat, final int setNo, final int groupDelta) {
    this.questionCat = questionCat;
    this.setNo = setNo;
    selectedGroups = new int[questionCat];
    for (int index = 0; index < questionCat; index++) {
        selectedGroups[index] = 1;
    }
    this.groupDelta = groupDelta;
}

public static void main(final String[] args) {
    int [][] input = {{1,11,21},{2,12,22},{3,13,23}};
    int [][] output = new int [100][100];
    final int questionCat = 3, setNo = 3, groupDelta = 10;
    GenerateTestSets p = new GenerateTestSets(questionCat, setNo, groupDelta);
    int selectedGroups[] = p.getNextSelection();
    while (selectedGroups != null) {

        for (int index = 0; index < selectedGroups.length; index++) {
            //System.out.print("\t"+input[index][selectedGroups[index]]);
            output[index][selectedGroups[index]] = input[index][selectedGroups[index]];
            System.out.print("\t"+(selectedGroups[index]+1));
            //System.out.print("\t"+output[index][selectedGroups[index]]);
        }
        p.generateNextSelection();
        selectedGroups = p.getNextSelection();
        System.out.println();
    }
}

private void generateNextSelection() {
    boolean carry = false;
    for (int index = 0; index < questionCat; index++) {
        selectedGroups[index]++;
        carry = selectedGroups[index] > setNo;
        if (carry) {
            selectedGroups[index] = 1;
        } else {
            break;
        }
    }
    if (carry) {
        selectedGroups = null;
    }
}

public int[] getNextSelection() {
    int[] cpy;
    if (selectedGroups == null) {
        cpy = null;
    } else {
        cpy = new int[selectedGroups.length];
        for (int index = 0; index < selectedGroups.length; index++) {
            cpy[index] =  ((selectedGroups[index] - 1));
        }
    }
    return cpy;
}
}