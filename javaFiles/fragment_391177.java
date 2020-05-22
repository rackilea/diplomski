import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public abstract class Node {

private List<Integer> allSamples;
private List<Record> dataSet;
private int classificationLabelIndex;
private int entropy;

public Node(List<Record> dataSet, int labelIndex) {
    this.allSamples = new ArrayList<Integer>();
    this.dataSet = dataSet;
    this.classificationLabelIndex = labelIndex;
    this.entropy = 0;
}