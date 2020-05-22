import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.ClassNode;

public class DependencyDetector {

    private static class Node implements Comparable<Node> {
        private final String binaryName;
        private final Node[] imports;
        private final int score;

        private Node(String binaryName, Node...imports) {
            this.binaryName = binaryName;
            this.imports = imports;
            this.score = calculateScore(imports);
        }

        public int compareTo(Node o) {
            return score - o.score;
        }

        private int calculateScore(Node...imports) {
            int newScore = 0;
            for (Node n : imports) {
                if (n.score >= newScore) {
                    newScore = n.score + 1;
                }
            }
            return newScore;
        }
    }

    private Map<String, Node> nodes = new HashMap<String, Node>();

    public DependencyDetector add(ClassNode node) {
        Node n = nodes.get(node.name);
        if (n == null) {
            n = createNode(node);
        }
        return this;
    }

    private Node createNode(ClassNode node) {
        String binaryName = node.name;
        String[] importNames = extractImportedBinaryNames(node);
        Node[] imports = new Node[importNames.length];
        for (int i = 0; i < imports.length; i++) {
            String importName = importNames[i];
            Node imp = nodes.get(importName);
            if (imp == null) {
                ClassNode cn = new ClassNode();
                String path = importName.replace('.', '/') + ".class";
                try {
                    new ClassReader(
                            ClassLoader.getSystemResourceAsStream(path)
                        ).accept(cn, ClassReader.SKIP_CODE);
                } catch (IOException e) {
                    throw new RuntimeException(
                        "could not read class " + importName);
                }
                imp = createNode(cn);
                nodes.put(importName, imp);
            }
            imports[i] = imp;
        }
        Node result = new Node(binaryName, imports);
        nodes.put(binaryName, result);
        return result;
    }

    private String[] extractImportedBinaryNames(ClassNode node) {
        String binaryName = node.name;
        ArrayList<String> nodesToAdd = new ArrayList<String>();
        int endOfOuter = binaryName.lastIndexOf('$');
        if (endOfOuter >= 0) {
            nodesToAdd.add(binaryName.substring(0, endOfOuter));
        }
        if (node.superName != null) {
            nodesToAdd.add(node.superName);
        }
        if (node.interfaces != null) {
            for (String interf : (List<String>) node.interfaces) {
                if (interf != null) {
                    nodesToAdd.add(interf);
                }
            }
        }
        return nodesToAdd.toArray(new String[nodesToAdd.size()]);
    }

    public String[] getClassesToLoad(String...binaryNames) {
        String[] classNames = binaryNames != null && binaryNames.length > 0
                ? binaryNames.clone()
                : nodes.keySet().toArray(new String[nodes.size()]);
        ArrayDeque<Node> dependencyQueue = new ArrayDeque<Node>();
        for (String className : classNames) {
            Node node = nodes.get(className.replace('.', '/'));
            dependencyQueue.add(node);
            if (node == null) {
                throw new RuntimeException(
                    "Class " + className + " was not registered");
            }
        }
        HashMap<String, Node> dependencyMap = new HashMap<String, Node>();
        while (!dependencyQueue.isEmpty()) {
            Node node = dependencyQueue.removeFirst();
            dependencyMap.put(node.binaryName, node);
            for (Node i : node.imports) {
                dependencyQueue.addLast(i);
            }
        }
        ArrayList<Node> usedNodes =
            new ArrayList<Node>(dependencyMap.values());
        Collections.sort(usedNodes);
        String[] result = new String[usedNodes.size()];
        int i = 0;
        for (Node n : usedNodes) {
            result[i++] = n.binaryName.replace('/', '.');
        }
        return result;
    }

    public boolean contains(String binaryName) {
        return nodes.containsKey(binaryName.replace('.', '/'));
    }
}