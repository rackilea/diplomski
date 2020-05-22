import org.apache.commons.io.input.ReversedLinesFileReader;
                import org.w3c.dom.Node;
                import org.w3c.dom.bootstrap.DOMImplementationRegistry;
                import org.w3c.dom.ls.DOMImplementationLS;
                import org.w3c.dom.ls.LSOutput;
                import org.w3c.dom.ls.LSSerializer;
                import org.xml.sax.InputSource;
                import org.xml.sax.SAXException;
                import java.io.*;
                import java.nio.file.Files;
                import java.nio.file.Path;
                import java.nio.file.Paths;
                import java.nio.file.StandardOpenOption;
                import javax.xml.transform.*;
                import javax.xml.parsers.*;


                public class ReverseXMLTags {

                    public static void main(String[] args) throws ParserConfigurationException,IOException,SAXException,TransformerException{
                        String ch;
                        String destinationPath=args[1]; // args[1]- path of the file where we want to write the content of the formatted xml tags
                        String tempPath="C://temp.xml"; // We will write to a temp file and delete it later
                    try(ReversedLinesFileReader fr = new ReversedLinesFileReader(new File(args[0]));)
                    {
                             Path path = Paths.get(tempPath);
                             Files.deleteIfExists(path);
                             Files.createFile(path);
                        do {
                            ch = fr.readLine();         
                            Files.write(path, ch.getBytes(),StandardOpenOption.APPEND); //StandardOpenOption.APPEND - it will append the content in temp file

                        } while (ch != null);

                    }
                        catch(Exception e)
                        {
                            formatXML(tempPath,destinationPath);
                        }

                    }

                    public static void formatXML(String path,String destinationPath) throws IOException
                    {   
                        Path deletePath = Paths.get(path);
                        try
                        {
                            final InputSource src = new InputSource(new FileInputStream(new File(path)));
                            final Node document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(src).getDocumentElement();
                            final DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
                            final DOMImplementationLS impl = (DOMImplementationLS) registry.getDOMImplementation("LS");
                            final LSSerializer writer = impl.createLSSerializer();
                            writer.getDomConfig().setParameter("format-pretty-print",Boolean.TRUE);
                            LSOutput lsOutput =  impl.createLSOutput();
                            lsOutput.setEncoding("UTF-8");  // For enabling UTF -8 else it will create in UTF-16 which will not open in browser
                            Writer stringWriter = new StringWriter();
                            lsOutput.setCharacterStream(stringWriter);
                            writer.write(document, lsOutput);     
                            String result = stringWriter.toString();
                            Path formattedpath = Paths.get(destinationPath);
                            Files.createFile(formattedpath);            
                            Files.deleteIfExists(deletePath);
                            Files.write(formattedpath, result.getBytes(),StandardOpenOption.APPEND);


                        } catch (Exception e)
                        {
                        }
                    }

                }