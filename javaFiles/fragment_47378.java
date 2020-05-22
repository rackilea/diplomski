@Test
public void shouldDisplayAtLeastOneServer() {
Assert.assertThat(webDriver.findElement(By.id("tabset"))
        .findElement(By.tagName("ul"))
        .findElements(By.tagName("li"))
        .size(), Matchers.greaterThan(0));
}