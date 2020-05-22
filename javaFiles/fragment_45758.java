import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class SomeTest {

        @Test
        public void test() {
            ExpressionParser parser = new SpelExpressionParser();

            Expression exp = parser.parseExpression(
                "This is user #{randomString(5)} and he is #{randomInt(18,60)} years old!", 
                new TemplateParserContext() );

            //alternative
            //Expression exp = parser.parseExpression(
            //        "'This is user ' + randomString(5) + ' and he is ' + randomInt(18,60) + ' years old!'");
            //    String message = (String) exp.getValue( new StandardEvaluationContext(this) );


            String message = (String) exp.getValue( new StandardEvaluationContext(this) );
        }

        public String randomString(int i) {
            return "rs-" + i;
        }

        public String randomInt(int i, int j) {
            return "ri-" + i + ":" + "j";
        }

    }