package grails.boot;

import static org.junit.Assert.assertTrue;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyCodeSource;
import groovy.lang.GroovyObject;

import java.security.CodeSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.codehaus.groovy.ast.ClassHelper;
import org.codehaus.groovy.ast.ClassNode;
import org.codehaus.groovy.ast.expr.ArgumentListExpression;
import org.codehaus.groovy.ast.expr.ArrayExpression;
import org.codehaus.groovy.ast.expr.ConstantExpression;
import org.codehaus.groovy.ast.expr.Expression;
import org.codehaus.groovy.ast.expr.MethodCallExpression;
import org.codehaus.groovy.ast.expr.VariableExpression;
import org.codehaus.groovy.ast.stmt.ExpressionStatement;
import org.codehaus.groovy.classgen.GeneratorContext;
import org.codehaus.groovy.control.CompilationFailedException;
import org.codehaus.groovy.control.CompilationUnit;
import org.codehaus.groovy.control.CompilerConfiguration;
import org.codehaus.groovy.control.Phases;
import org.codehaus.groovy.control.SourceUnit;
import org.junit.Test;

public class GroovyTestAutonomous {

    @Test
    public void testParsing() throws Exception {
        SimpleCustomizedGroovyClassLoader customizedGroovyClassLoader = new SimpleCustomizedGroovyClassLoader(new GroovyClassLoader());
        Class<?> groovyClass;
        try {
            groovyClass = customizedGroovyClassLoader.parseClass(new GroovyCodeSource(
                    "{fact -> fact.a != null}",
                    customizedGroovyClassLoader.generateScriptName(),
                    "/scriptSandbox"));
        } catch (Exception e) {
            System.out.println("Error loading class");
            throw e;
        }
        assertTrue(groovyClass != null);
        GroovyObject groovyObject = (GroovyObject) groovyClass.newInstance();

        Boolean attrSingle = (Boolean) groovyObject.getProperty("attrSingle");
        System.out.println("Single=" + attrSingle);

        List<String> attrList = new ArrayList<String>();
        Object[] objects = (Object[]) groovyObject.getProperty("attrList");
        for (Object o : objects)
            attrList.add((String) o);
        System.out.println("List=" + attrList);
    }

    class SimpleCustomizedGroovyClassLoader extends GroovyClassLoader {
        public SimpleCustomizedGroovyClassLoader(ClassLoader cl) {
            super(cl);
        }

        @Override
        protected CompilationUnit createCompilationUnit(CompilerConfiguration config, CodeSource source) {
            CompilationUnit cu = super.createCompilationUnit(config, source);
            cu.addPhaseOperation(new CompilationUnit.PrimaryClassNodeOperation() {
                        public void call(SourceUnit sourceUnit, GeneratorContext context, ClassNode classNode) throws CompilationFailedException {

                            classNode.addObjectInitializerStatements(new ExpressionStatement(new MethodCallExpression(
                                    VariableExpression.THIS_EXPRESSION, "setProperty",
                                    new ArgumentListExpression(new ConstantExpression("attrSingle"),
                                    new ConstantExpression(true)))));

                            List<Expression> args = new ArrayList<Expression>();
                            ArgumentListExpression argumentListExpression = new     ArgumentListExpression();
                            argumentListExpression.addExpression(new ConstantExpression("attrList"));
                            for (String attributeName : Arrays.asList("a", "b", "c"))
                                args.add(new ConstantExpression(attributeName));

                            ArrayExpression arrayExpression = new ArrayExpression(ClassHelper.make(Object.class), args);
                            argumentListExpression.addExpression(arrayExpression);
                            classNode.addObjectInitializerStatements(new ExpressionStatement(new MethodCallExpression(
                                    VariableExpression.THIS_EXPRESSION, "setProperty", argumentListExpression)));
                        }
                    }, Phases.CONVERSION);
            return cu;
        }
    }
}