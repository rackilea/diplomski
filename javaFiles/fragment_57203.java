// AutomaticCheckstyleFix.java:

package q45326752;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.*;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.stmt.*;

import java.io.File;
import java.io.FileNotFoundException;

public class AutomaticCheckstyleFix {
    private MethodDeclaration bestMatchMethod;
    private int bestMatchMethodLineNumber;
    private Statement statementByLineNumber;

    public static void main(final String[] arguments) {
        final String filePath = "q45326752\\input\\Example.java";

        try {
            new AutomaticCheckstyleFix().fixSimpleCheckstyleIssues(new File(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void fixSimpleCheckstyleIssues(File file) throws FileNotFoundException {
        CompilationUnit javaClass = JavaParser.parse(file);
        System.out.println("Original Java class:\n\n" + javaClass);
        System.out.println();
        System.out.println();

        // Example.java:4:29: Parameter arguments should be final. [FinalParameters]
        MethodDeclaration methodIssue1 = getMethodByLineNumber(javaClass, 4);
        if (methodIssue1 != null) {
            methodIssue1.getParameterByName("arguments")
                  .ifPresent(parameter -> parameter.setModifier(Modifier.FINAL, true));
        }

        // Example.java:7:13: Variable 'perfectNumber' should be declared final.
        // [FinalLocalVariable]
        Statement statementIssue2 = getStatementByLineNumber(javaClass, 7);
        if (statementIssue2 instanceof ExpressionStmt) {
            Expression expression = ((ExpressionStmt) statementIssue2).getExpression();
            if (expression instanceof VariableDeclarationExpr) {
                ((VariableDeclarationExpr) expression).addModifier(Modifier.FINAL);
            }
        }

        System.out.println("Modified Java class:\n\n" + javaClass);
    }

    private MethodDeclaration getMethodByLineNumber(CompilationUnit javaClass,
                                                    int issueLineNumber) {
        bestMatchMethod = null;

        javaClass.getTypes().forEach(type -> type.getMembers().stream()
                .filter(declaration -> declaration instanceof MethodDeclaration)
                .forEach(method -> {
                    if (method.getTokenRange().isPresent()) {
                        int methodLineNumber = method.getTokenRange().get()
                                .getBegin().getRange().begin.line;
                        if (bestMatchMethod == null
                                || (methodLineNumber < issueLineNumber
                                && methodLineNumber > bestMatchMethodLineNumber)) {
                            bestMatchMethod = (MethodDeclaration) method;
                            bestMatchMethodLineNumber = methodLineNumber;
                        }
                    }
                })
        );

        return bestMatchMethod;
    }

    private Statement getStatementByLineNumber(CompilationUnit javaClass,
                                               int issueLineNumber) {
        statementByLineNumber = null;

        MethodDeclaration method = getMethodByLineNumber(javaClass, issueLineNumber);
        if (method != null) {
            method.getBody().ifPresent(blockStmt
                    -> blockStmt.getStatements().forEach(statement
                    -> statement.getTokenRange().ifPresent(tokenRange -> {
                if (tokenRange.getBegin().getRange().begin.line == issueLineNumber) {
                    statementByLineNumber = statement;
                }
            })));
        }

        return statementByLineNumber;
    }
}