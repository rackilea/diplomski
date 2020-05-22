import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$$;


public static Condition hasChildWithCondition(final By locator, final Condition condition) {
    return new Condition("hasChildWithCondition") {
        public boolean apply(WebElement element) {
            return element.findElements(locator).stream().
                    filter(child -> condition.apply(child)).count() > 0;
        }

        public String toString() {
            return this.name
        }
    };
}