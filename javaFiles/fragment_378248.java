package cx.ath.jbzdak.diesIrae.util.wrappergen;

    import net.miginfocom.swing.MigLayout;

    import javax.swing.*;
    import static java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment;
    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.io.*;
    import java.nio.charset.Charset;
    import java.util.ArrayList;
    import java.util.Collections;
    import java.util.List;
    import java.util.regex.Matcher;
    import java.util.regex.Pattern;

    /**
     * Displays a window. In this window you have to specify two things:
     * <p/>
     * 1. Name of header file that you want to process.
     * <p/>
     * 2. Name of output files extension will be added automatically. We will override any existing files.
     *
     * <p/>
     * Dependencies: MigLayout
     * <p/>
     * Actual wrapper generation is done inside WrapperGen class.
     * <p/>
     * KNOWN ISSUES:
     * <p/>
     * 1. Ignores preprocessor so may extract finction names that are inside <code>#if false</code>.
     * <p/>
     * 2. Ignores comments
     * <p/>
     * 3. May fail to parse werid parameter syntax. . .
     *
     * Created by IntelliJ IDEA.
     * User: Jacek Bzdak 
     */
    public class WrapperGenerator {

        public static final Charset charset = Charset.forName("UTF-8");


        WrapperGen generator = new WrapperGen();

        // GUI CODE:

        File origHeader, targetHeader, targetCpp;

        JTextField newHeaderFileName;

        JFrame wrapperGeneratorFrame;
        {
            wrapperGeneratorFrame = new JFrame();
            wrapperGeneratorFrame.setTitle("Zamknij mnie!"); //Wrapper generator
            wrapperGeneratorFrame.setLayout( new MigLayout("wrap 2, fillx", "[fill,min!]"));
            wrapperGeneratorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ActionListener buttonListener = new ActionListener() {
                JFileChooser fileChooser = new JFileChooser();
                {
                    fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
                        @Override
                        public boolean accept(File f) {
                            return f.isDirectory() || f.getName().matches(".*\\.h(?:pp)?");
                        }
                        @Override
                        public String getDescription() {
                            return "Header files";
                        }
                    });
                    fileChooser.setCurrentDirectory(new File("C:\\Documents and Settings\\jb\\My Documents\\Visual Studio 2008\\Projects\\dll\\dll"));
                }
                public void actionPerformed(ActionEvent e) {
                    if(JFileChooser.APPROVE_OPTION == fileChooser.showOpenDialog(wrapperGeneratorFrame)){
                        origHeader = fileChooser.getSelectedFile();
                    }
                }
            };
            wrapperGeneratorFrame.add(new JLabel("Original header file"));
            JButton jButton = new JButton("Select header file");
            jButton.addActionListener(buttonListener);
            wrapperGeneratorFrame.add(jButton);
            wrapperGeneratorFrame.add(new JLabel("Result files prefix"));
            newHeaderFileName = new JTextField("dll_wrapper");
            wrapperGeneratorFrame.add(newHeaderFileName);
            ActionListener doListener = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    targetHeader = new File(origHeader.getParentFile(), newHeaderFileName.getText() + ".h");
                    targetCpp = new File(origHeader.getParentFile(), newHeaderFileName.getText() + ".cpp");
                    try {
                        targetHeader.createNewFile();
                        targetCpp.createNewFile();
                        generator.reader = new InputStreamReader(new FileInputStream(origHeader),charset);
                        generator.cppWriter = new OutputStreamWriter(new FileOutputStream(targetCpp), charset);
                        generator.heaerWriter = new OutputStreamWriter(new FileOutputStream(targetHeader), charset);
                        generator.parseReader();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                        JOptionPane.showMessageDialog(wrapperGeneratorFrame, "ERROR:" + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            };
            JButton go = new JButton("go");
            go.addActionListener(doListener);
            wrapperGeneratorFrame.add(go, "skip 1");
        }

        public static void main(String []args){
           SwingUtilities.invokeLater(new Runnable() {
               public void run() {
                   WrapperGenerator wgen = new WrapperGenerator();
                   JFrame f = wgen.wrapperGeneratorFrame;
                   wgen.wrapperGeneratorFrame.pack();
                   Point p = getLocalGraphicsEnvironment().getCenterPoint();
                   wgen.wrapperGeneratorFrame.setLocation(p.x-f.getWidth()/2, p.y-f.getHeight()/2);
                   wgen.wrapperGeneratorFrame.setVisible(true);
               }
           });
        }
    }

    /**
     * Does the code parsing and generation
     */
    class WrapperGen{

        /**
         * Method is basically syntax like this: <code>(anything apart from some special chars like #;) functionName(anything)</code>;
         * Method declarations may span many lines.
         */
        private static final Pattern METHOD_PATTERN =
                                 //1          //2              //params
                Pattern.compile("([^#;{}]*\\s+\\w[\\w0-9_]+)\\(([^\\)]*)\\);", Pattern.MULTILINE);
        //1 - specifiers - including stuff like __dllspec(export)...
        //2 - function name
        //3 param list

        /**
         * Generated functions will have name prefixet with #RESULT_PREFIX
         */
        private static final String RESULT_PREFIX = "DLL_WRAPPER_";

        /**
         * Specifiers of result will be prefixed with #RESULT_SPECIFIER
         */
        private static final String RESULT_SPECIFIER =  "__declspec(dllexport) ";

        Reader reader;

        Writer heaerWriter;

        Writer cppWriter;

        public void parseReader() throws IOException {
            StringWriter writer = new StringWriter();
            int read;
            while((read = reader.read())!=-1){
                writer.write(read);
            }
            reader.close();
            heaerWriter.append("#pragma once\n\n\n");
            heaerWriter.append("#include \"stdafx.h\"\n\n\n"); //Standard Visual C++ import file.
            cppWriter.append("#include \"stdafx.h\"\n\n\n");
            Matcher m = METHOD_PATTERN.matcher(writer.getBuffer());
            while(m.find()){
                System.out.println(m.group());
                handleMatch(m);
            }
            cppWriter.close();
            heaerWriter.close();
        }

        public void handleMatch(Matcher m) throws IOException {
            Method meth = new Method(m);
            outputHeader(meth);
            outputCPP(meth);
        }

        private void outputDeclaration(Method m, Writer writer) throws IOException {
            //writer.append(RESULT_SPECIFIER);
            writer.append(m.specifiers);
            writer.append(" ");
            writer.append(RESULT_PREFIX);
            writer.append(m.name);
            writer.append("(");
            for (int ii = 0; ii < m.params.size(); ii++) {
                Parameter p =  m.params.get(ii);
                writer.append(p.specifiers);
                writer.append(" ");
                writer.append(p.name);
                if(ii!=m.params.size()-1){
                    writer.append(", ");
                }
            }
            writer.append(")");
        }

        public void outputHeader(Method m) throws IOException {

            outputDeclaration(m, heaerWriter);
            heaerWriter.append(";\n\n");
        }

        public void outputCPP(Method m) throws IOException {
            cppWriter.append(RESULT_SPECIFIER);
            outputDeclaration(m, cppWriter);
            cppWriter.append("{\n\t");
            if (!m.specifiers.contains("void") || m.specifiers.matches(".*void\\s*\\*.*")) {
                cppWriter.append("return ");
            }
            cppWriter.append(m.name);
            cppWriter.append("(");
            for (int ii = 0; ii < m.params.size(); ii++) {
                Parameter p =  m.params.get(ii);
                cppWriter.append(p.name);
                if(ii!=m.params.size()-1){
                    cppWriter.append(", ");
                }
            }
            cppWriter.append(");\n");
            cppWriter.append("}\n\n");
        }

    }

    class Method{
        private static final Pattern NAME_REGEXP =
                                     //1      //2
                Pattern.compile("\\s*(.*)\\s+(\\w[\\w0-9]+)\\s*", Pattern.MULTILINE);
        //1 - all specifiers - including __declspec(dllexport) and such ;)
        //2 - function name

        public final List<Parameter> params;

        public final String name;

        public final String specifiers;

        public Method(Matcher m) {
            params = Collections.unmodifiableList(Parameter.parseParamList(m.group(2)));
            Matcher nameMather = NAME_REGEXP.matcher(m.group(1));
            System.out.println("ALL: " + m.group()); 
            System.out.println("G1: " + m.group(1));
            if(!nameMather.matches()){
                throw new IllegalArgumentException("for string "  + m.group(1));
            }
    //        nameMather.find();
            specifiers = nameMather.group(1);
            name = nameMather.group(2);
        }
    }

    class Parameter{

        static final Pattern PARAMETER_PATTERN =
                                      //1           //2
                Pattern.compile("\\s*(?:(.*)\\s+)?([\\w\\*&]+[\\w0-9]*[\\*&]?)\\s*");
        //1 - Most probably parameter type and specifiers, but may also be empty - in which case name is empty, and specifiers are in 2
        //2 - Most probably parameter type, sometimes prefixed with ** or &* ;), also
        // 'char *' will be parsed as grup(1) == char, group(2) = *.

        /**
         * Used to check if group that represenrs parameter name is in fact param specifier like '*'.
          */
        static final Pattern STAR_PATTERN =
                Pattern.compile("\\s*([\\*&]?)+\\s*");

        /**
         * If
         */
        static final Pattern NAME_PATTERN =
                Pattern.compile("\\s*([\\*&]+)?(\\w[\\w0-9]*)\\s*");

        public final String name;
        public final String specifiers;

         public Parameter(String param, int idx) {
            System.out.println(param);
            Matcher m = PARAMETER_PATTERN.matcher(param);
            String name = null;
            String specifiers = null;
            if(!m.matches()){
                throw new IllegalStateException(param);
            }
            name = m.group(2);
            specifiers = m.group(1);
            if(specifiers==null || specifiers.isEmpty()){ //Case that parameter has no name like 'int', or 'int**'
                specifiers = name;
                name = null;
            }else if(STAR_PATTERN.matcher(name).matches()){ //Case that parameter has no name like 'int *'
                specifiers += name;
                name = null;
            }else if(NAME_PATTERN.matcher(name).matches()){ //Checks if name contains part of type like '**ptrData', and extracts '**'
                Matcher m2 = NAME_PATTERN.matcher(name);
                m2.matches();
                if(m2.group(1)!=null){
                    specifiers += m2.group(1);
                    name = m2.group(2);
                }

            }
            if(name==null){
                name = "param" + idx;
            }
            this.specifiers = specifiers;
            this.name = name;
        }

        public static List<Parameter> parseParamList(String paramList){
            List<Parameter> result = new ArrayList<Parameter>();
            String[] params = paramList.split(",");
            int idx = 0;
            for(String param : params){
                Parameter p = new Parameter(param, idx++);
                result.add(p);
            }
            if(result.size()==1){
                Parameter p = result.get(0);
                if(p.specifiers.matches("\\s*void\\s*")){
                    return Collections.emptyList();
                }
            }
            return result;
        }
    }