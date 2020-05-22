// init random
Random rnd = new Random();

// first get number of rows -- this returns 10
int rowCount = driver.findElements(By.xpath("//div[contains(@class, 'table_row')]")).size();

// then iterate the rows from 2-10 (WebElement lists are 1-based index, skip first header row)
for (int i = 2; i <= rowCount; i++)
{
    // get radio buttons for this row -- use i to get the row index
    // this returns 6
    List<WebElement> cells = driver.findElements(By.xpath("//div[contains(@class, 'table_row')][" + i + "]//div[@class='table_cell_text']")

    // get a random cell and click it -- start with 1 so we can skip first column
    cells.get(rnd.nextInt((cells.size() - 1) + 1).click();
}