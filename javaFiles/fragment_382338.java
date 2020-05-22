List<String> cellsAfterRefresh = driver
        .findElements(By
                .xpath("//table/descendant::*/th[not(text()='Header 4') and not(text()='Header 5')]" +
                        " | //table/descendant::*/td"))
        .stream()
        .map(WebElement::getText)
        .collect(Collectors.toList());