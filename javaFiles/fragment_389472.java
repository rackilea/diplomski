import soot.Body;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.jimple.toolkits.annotation.logic.Loop;
import soot.toolkits.graph.Block;
import soot.toolkits.graph.BlockGraph;
import soot.toolkits.graph.ExceptionalBlockGraph;
import soot.toolkits.graph.LoopNestTree;

public class DisplayLoops {
    public static void main(String[] args) throws Exception {
        SootClass sootClass = Scene.v().loadClassAndSupport("TestLoop");
        sootClass.setApplicationClass();

        Body body = null;
        for (SootMethod method : sootClass.getMethods()) {
            if (method.getName().equals("foo")) {
                if (method.isConcrete()) {
                    body = method.retrieveActiveBody();
                    break;
                }
            }
        }

        System.out.println("**** Body ****");
        System.out.println(body);
        System.out.println();

        System.out.println("**** Blocks ****");
        BlockGraph blockGraph = new ExceptionalBlockGraph(body);
        for (Block block : blockGraph.getBlocks()) {
            System.out.println(block);
        }
        System.out.println();

        System.out.println("**** Loops ****");
        LoopNestTree loopNestTree = new LoopNestTree(body);
        for (Loop loop : loopNestTree) {
            System.out.println("Found a loop with head: " + loop.getHead());
        }
    }
}