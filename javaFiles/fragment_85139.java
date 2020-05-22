import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.List;
import org.junit.runner.Result;
import static org.junit.Assert.assertEquals;

class ProductCategory {
    enum Type {
        Aggregate, Individual
    };

    public ProductCategory(String a, String b, Type t) {

    }
}

@RunWith(Parameterized.class)
    public class ProductCategoryTest {


        private boolean isAggregate;
        private ProductCategory category;

        public ProductCategoryTest(boolean isAggregate, ProductCategory category) {
            this.isAggregate = isAggregate;
            this.category = category;
        }

        @Parameterized.Parameters
        public static List<Object[]> categoryList() {
            return Arrays.asList(new Object[][]{
                    {true, new ProductCategory("A", "Laundry", ProductCategory.Type.Aggregate)},
                    {false, new ProductCategory("B", "Dryer", ProductCategory.Type.Individual)},
            });
        }

        @Test
        public void isAggregateProductCategory() throws Exception {
            //assertEquals(isAggregate, category.isAggregateProductCategory());
        }


        public static void main(String[] args) {
            Result result = JUnitCore.runClasses(ProductCategoryTest.class);

            for (Failure failure : result.getFailures()) {
               System.out.println(failure.toString());
            }

            System.out.println(result.wasSuccessful());
         }
    }