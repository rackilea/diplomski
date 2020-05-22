package com.debug;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * This handler allows you to read from a text file a list of case statements, sort the case statements<br />
 * in natural order, and write to a file.
 * 
 * @author Vincent
 */
public class CaseHandler {

    /**
     * This denotes the use of numerical or text based case statements.
     */
    public enum CaseType {
        String, Integer;
    }

    private boolean autoSort = false;
    private ArrayList<Case> cases = new ArrayList<Case>();
    private CaseType caseType;
    private File file;

    /**
     * This construcs a basic <code>CaseHandler</code> in which a file must be provided
     * within the {@link #readFile(String)} method.
     * <b>Note:</b> The file expected should always be a text file with only the case statements.<br />
     * The formatting is not important.
     * 
     * @param caseType The type of case this instance should use.
     * @see {@link CaseType}, {@link CaseHandler}
     */
    public CaseHandler(CaseType caseType) {
        this.caseType = caseType;
    }

    /**
     * This construcs a <code>CaseHandler</code> with a file provided.<br />
     * <b>Note:</b> The file expected should always be a text file with only the case statements.<br />
     * The formatting is not important.
     * 
     * @param fileName The full file path and name to be read from and/or written to.
     * @param caseType The type of case this instance should use.
     * @see {@link CaseType}, {@link CaseHandler}
     */
    public CaseHandler(String fileName, CaseType caseType) {
        this.caseType = caseType;
        this.file = new File(fileName);
    }

    /**
     * This construcs a <code>CaseHandler</code> with a file provided.<br />
     * <b>Note:</b> The file expected should always be a text file with only the case statements.<br />
     * The formatting is not important.
     * 
     * @param fileName The full file path and name to be read from and/or written to.
     * @param caseType The type of case this instance should use.
     * @param autoSort Enables auto sorting in the {@link #readFile()}
     */
    public CaseHandler(String fileName, CaseType caseType, boolean autoSort) {
        this.caseType = caseType;
        this.file = new File(fileName);
        this.autoSort = autoSort;
    }

    /**
     * Reads the file where the case statements are stored line by line.<br />
     * When the word case is found it creates a new temp <code>ArrayList</code> of <code>String</code>. <br />
     * If a temp <code>ArrayList</code> already exists then it overwrites the <code>ArrayList</code>. <br />
     * When the word break is found it then creates a <code>Case<code> object and stores the lines.<br />
     * This then stores the <code>Case</code> objects into an <code>ArrayList</code> for later use.
     * If auto sort has been enabled in the constructor then this will also sort the <code>Case</code> objects.
     * 
     * @throws IOException
     * @see {@link ArrayList}, {@link FileReader}, {@link BufferedReader}, {@link Case}
     */
    public void readFile() throws IOException {
        if (this.file != null && this.file.exists()) {
            FileReader fr = null;
            BufferedReader br = null;
            try {
                fr = new FileReader(this.file);
                br = new BufferedReader(fr);
                String line = "";
                ArrayList<String> lines = null;
                while ((line = br.readLine()) != null) {
                    if (line.contains("case")) {
                        if (lines != null && lines.get(lines.size() - 1).contains("break")) {
                            lines = new ArrayList<String>();
                        } else {
                            lines = new ArrayList<String>();
                        }
                    }
                    lines.add(line);
                    if (line.contains("break")) {
                        String caseName = lines.get(0).replace("case", "").replace(":", "").trim();
                        Case aCase = null;
                        if (caseType == CaseType.Integer) {
                            aCase = new Case(Integer.parseInt(caseName), lines);
                        } else if (caseType == CaseType.String) {
                            aCase = new Case(caseName, lines);
                        }
                        cases.add(aCase);
                    }
                }
                if (this.autoSort) {
                    this.sortCases();
                }
            } finally {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
            }
        } else {
            System.out.println("File " + this.file.getName() + " does not exist!");
        }
    }

    /**
     * Reads the file where the case statements are stored line by line.<br />
     * When the word case is found it creates a new temp <code>ArrayList</code> of <code>String</code>. <br />
     * If a temp <code>ArrayList</code> already exists then it overwrites the <code>ArrayList</code>. <br />
     * When the word break is found it then creates a <code>Case<code> object and stores the lines.<br />
     * This then stores the <code>Case</code> objects into an <code>ArrayList</code> for later use.
     * If auto sort has been enabled in the constructor then this will also sort the <code>Case</code> objects.
     * 
     * @param fileName The full file path and name to be read from and/or written to.
     * @throws IOException
     * @see {@link ArrayList}, {@link FileReader}, {@link BufferedReader}, {@link Case}
     */
    public void readFile(String fileName) throws IOException {
        this.file = new File(fileName);
        if (this.file != null && this.file.exists()) {
            FileReader fr = null;
            BufferedReader br = null;
            try {
                fr = new FileReader(this.file);
                br = new BufferedReader(fr);
                String line = "";
                ArrayList<String> lines = null;
                while ((line = br.readLine()) != null) {
                    if (line.contains("case")) {
                        if (lines != null && lines.get(lines.size() - 1).contains("break")) {
                            lines = new ArrayList<String>();
                        } else {
                            lines = new ArrayList<String>();
                        }
                    }
                    lines.add(line);
                    if (line.contains("break")) {
                        String caseName = lines.get(0).replace("case", "").replace(":", "").trim();
                        Case aCase = null;
                        if (caseType == CaseType.Integer) {
                            aCase = new Case(Integer.parseInt(caseName), lines);
                        } else if (caseType == CaseType.String) {
                            aCase = new Case(caseName, lines);
                        }
                        cases.add(aCase);
                    }
                }
                if (this.autoSort) {
                    this.sortCases();
                }
            } finally {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
            }
        } else {
            System.out.println("File " + this.file.getName() + " does not exist!");
        }
    }

    /**
     * Sorts the {@link ArrayList} in alphabetical or numerical order.<br />
     * <b>Note:</b> This will <b>NOT</b> sort clusters of case statements.
     * @see {@link Collections#sort(java.util.List)}
     */
    public void sortCases() {
        if (cases.size() > 0) {
            Collections.sort(cases, Comparator.naturalOrder());
        }
    }

    /**
     * Overwrites the file provided to the <code>CaseHandler</code> with the cases list.
     * 
     * @throws IOException
     * @see {@link ArrayList}, {@link FileWriter}, {@link BufferedWriter}, {@link Case}
     */
    public void writeCases() throws IOException {
        if (this.file.exists()) {
            FileWriter fw = null;
            BufferedWriter bw = null;
            try {
                fw = new FileWriter(this.file);
                bw = new BufferedWriter(fw);
                for (Case aCase : cases) {
                    for (String line : aCase.getLines()) {
                        bw.write(line);
                        bw.newLine();
                    }
                }
            } finally {
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            }
        }
    }

    /**
     * Overwrites the file provided to with the cases list.
     * 
     * @param fileName The full file path and name to be read from and/or written to.
     * @throws IOException
     * @see {@link ArrayList}, {@link FileWriter}, {@link BufferedWriter}, {@link Case}
     */
    public void writeCases(String fileName) throws IOException {
        File outFile = new File(fileName);
        if (!outFile.exists()) {
            outFile.createNewFile();
        }
        if (outFile.exists()) {
            FileWriter fw = null;
            BufferedWriter bw = null;
            try {
                fw = new FileWriter(outFile);
                bw = new BufferedWriter(fw);
                for (Case aCase : cases) {
                    for (String line : aCase.getLines()) {
                        bw.write(line);
                        bw.newLine();
                    }
                }
            } finally {
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            }
        }
    }

    /**
     * Changes the case type.
     * 
     * @param caseType The new type of case this instance should use.
     * @see {@link CaseType}
     */
    public void setCaseType(CaseType caseType) {
        this.caseType = caseType;
    }
}