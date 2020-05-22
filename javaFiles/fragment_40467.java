import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import stackoverflow.objload.ObjectLoader.LineParser;
import stackoverflow.objload.ObjectLoader.Material;
import stackoverflow.objload.ObjectLoader.MtlLineParser;
import stackoverflow.objload.ObjectLoader.ObjLineParser;

public class ObjectLoaderTest
{
    public static void main(String[] args)
    {
        ObjectLoader objLoader = new ObjectLoader();

        try {
            PolygonGroup object = objLoader.loadObject("res/", "coffeCup.obj");
        } catch (IOException e) { 
            e.printStackTrace();
        }    

    }
}

class PolygonGroup
{
    public PolygonGroup(String name)
    {
    }

    public PolygonGroup()
    {
    }

    public void setFilename(String filename)
    {
    }

    public void addPolygonGroup(PolygonGroup currentGroup)
    {
    }
}
class Vector3D
{
    public Vector3D(float parseFloat, float parseFloat2, float parseFloat3)
    {
    }
}

class ObjectLoader {

    /**
     * The Material class wraps a ShadedTexture.
     */
    public static class Material {
        public File sourceFile;
    }

    /**
     * A LineParser is an interface to parse a line in a text file. Separate
     * LineParsers and are used for OBJ and MTL files.
     */
    protected interface LineParser {
        public void parseLine(String line) throws IOException, NumberFormatException, NoSuchElementException;
    }

    protected File path;
    protected List vertices;
    protected Material currentMaterial;
    protected HashMap materials;
    protected List lights;
    protected float ambientLightIntensity;
    protected HashMap parsers;
    private PolygonGroup object;
    private PolygonGroup currentGroup;

    /**
     * Creates a new ObjectLoader.
     */
    public ObjectLoader() {
        materials = new HashMap();
        vertices = new ArrayList();
        parsers = new HashMap();
        parsers.put("obj", new ObjLineParser());
        parsers.put("mtl", new MtlLineParser());
        currentMaterial = null;
        setLights(new ArrayList(), 1);
    }

    /**
     * Sets the lights used for the polygons in the parsed objects. After
     * calling this method calls to loadObject use these lights.
     */
    public void setLights(List lights, float ambientLightIntensity) {
        this.lights = lights;
        this.ambientLightIntensity = ambientLightIntensity;
    }

    /**
     * Loads an OBJ file as a PolygonGroup.
     */
    public PolygonGroup loadObject(String parent, String filename) throws IOException {
        object = new PolygonGroup();
        object.setFilename(filename);
        path = new File(parent);

        vertices.clear();
        currentGroup = object;
        parseFile(filename);

        return object;
    }

    /**
     * Gets a Vector3D from the list of vectors in the file. Negative indeces
     * count from the end of the list, postive indeces count from the beginning.
     * 1 is the first index, -1 is the last. 0 is invalid and throws an
     * exception.
     */
    protected Vector3D getVector(String indexStr) {
        int index = Integer.parseInt(indexStr);
        if (index < 0) {
            index = vertices.size() + index + 1;
        }
        return (Vector3D) vertices.get(index - 1);
    }

    /**
     * Parses an OBJ (ends with ".obj") or MTL file (ends with ".mtl").
     */
    protected void parseFile(String filename) throws IOException {
        // get the file relative to the source path
        File file = new File(path, filename);

        System.out.println("Reading "+file+", exists "+file.exists());
        BufferedReader reader = new BufferedReader(new FileReader(file));

        // get the parser based on the file extention
        LineParser parser = null;
        int extIndex = filename.lastIndexOf('.');
        if (extIndex != -1) {
            String ext = filename.substring(extIndex + 1);
            parser = (LineParser) parsers.get(ext.toLowerCase());
        }
        if (parser == null) {
            parser = (LineParser) parsers.get("obj");
        }

        // parse every line in the file
        while (true) {
            String line = reader.readLine();
            // no more lines to read
            if (line == null) {
                reader.close();
                return;
            }

            line = line.trim();

            // ignore blank lines and comments
            if (line.length() > 0 && !line.startsWith("#")) {
                // interpret the line
                try {
                    parser.parseLine(line);
                } catch (NumberFormatException ex) {
                    throw new IOException(ex.getMessage());
                } catch (NoSuchElementException ex) {
                    throw new IOException(ex.getMessage());
                }
            }

        }
    }

    /**
     * Parses a line in an OBJ file.
     */
    protected class ObjLineParser implements LineParser {

        public void parseLine(String line) throws IOException, NumberFormatException, NoSuchElementException {
            StringTokenizer tokenizer = new StringTokenizer(line);
            String command = tokenizer.nextToken();
            if (command.equals("v")) {
                // create a new vertex
                vertices.add(new Vector3D(Float.parseFloat(tokenizer.nextToken()), Float.parseFloat(tokenizer.nextToken()), Float.parseFloat(tokenizer.nextToken())));
            } else if (command.equals("f")) {
                // create a new face (flat, convex polygon)
                List currVertices = new ArrayList();
                while (tokenizer.hasMoreTokens()) {
                    String indexStr = tokenizer.nextToken();

                    // ignore texture and normal coords
                    int endIndex = indexStr.indexOf('/');
                    if (endIndex != -1) {
                        indexStr = indexStr.substring(0, endIndex);
                    }

                    currVertices.add(getVector(indexStr));
                }

                // create textured polygon
                Vector3D[] array = new Vector3D[currVertices.size()];
                currVertices.toArray(array);

            } else if (command.equals("g")) {
                // define the current group
                if (tokenizer.hasMoreTokens()) {
                    String name = tokenizer.nextToken();
                    currentGroup = new PolygonGroup(name);
                } else {
                    currentGroup = new PolygonGroup();
                }
                object.addPolygonGroup(currentGroup);
            } else if (command.equals("mtllib")) {
                // load materials from file
                String name = tokenizer.nextToken();
                parseFile(name);
            } else if (command.equals("usemtl")) {
                // define the current material
                String name = tokenizer.nextToken();
                currentMaterial = (Material) materials.get(name);
                if (currentMaterial == null) {
                    System.out.println("no material: " + name);
                }
            } else {
                // unknown command - ignore it
            }

        }
    }

    /**
     * Parses a line in a material MTL file.
     */
    protected class MtlLineParser implements LineParser {

        public void parseLine(String line) throws NoSuchElementException {
            StringTokenizer tokenizer = new StringTokenizer(line);
            String command = tokenizer.nextToken();

            if (command.equals("newmtl")) {
                // create a new material if needed
                String name = tokenizer.nextToken();
                currentMaterial = (Material) materials.get(name);
                if (currentMaterial == null) {
                    currentMaterial = new Material();
                    materials.put(name, currentMaterial);
                }
            } else if (command.equals("map_Kd")) {
                // give the current material a texture
                String name = tokenizer.nextToken();
                File file = new File(path, name);
                if (!file.equals(currentMaterial.sourceFile)) {
                    currentMaterial.sourceFile = file;
                }
            } else {
                // unknown command - ignore it
            }
        }
    }
}