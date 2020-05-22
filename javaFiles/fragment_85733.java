package org.matheclipse.core.examples;

import static org.matheclipse.core.expression.F.*;

import org.matheclipse.core.eval.ExprEvaluator;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.parser.client.SyntaxError;
import org.matheclipse.parser.client.math.MathException;

public class SO_ExpandExample {
    public static void main(String[] args) {
        try {
            ExprEvaluator util = new ExprEvaluator(false, 100);

            // expand an expression by using Expand() or ExpandAll() function
            IExpr result = util.evaluate("ExpandAll(-2(3u-x)-v)");
            // print: -6*u-v+2*x
            System.out.println(result.toString());

            // Show an expression in the Java form:
            String javaForm = util.toJavaForm("ExpandAll(-2(3u-x)-v)");
            // prints: ExpandAll(Plus(Times(CN2,Plus(Times(C3,u),Negate(x))),Negate(v)))
            System.out.println(javaForm.toString());

            // use the JavaForm:
            IAST function = ExpandAll(Plus(Times(CN2, Plus(Times(C3, u), Negate(x))), Negate(v)));
            result = util.evaluate(function);
            // print: -6*u-v+2*x
            System.out.println(result.toString());

        } catch (SyntaxError e) {
            // catch Symja parser errors here
            System.out.println(e.getMessage());
        } catch (MathException me) {
            // catch Symja math errors here
            System.out.println(me.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}