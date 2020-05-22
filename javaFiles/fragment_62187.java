//Set up the next marked content element with an MCID and create the containing TD structure element.
            PDPageContentStream contents = new PDPageContentStream(
                    pdf, pages.get(pageIndex), PDPageContentStream.AppendMode.APPEND, false);
            currentElem = addContentToParent(null, StandardStructureTypes.TD, pages.get(pageIndex), currentRow);

            //Make the actual cell rectangle and set as artifact to avoid detection.
            setNextMarkedContentDictionary(COSName.ARTIFACT.getName());
            contents.beginMarkedContent(COSName.ARTIFACT, PDPropertyList.create(currentMarkedContentDictionary));

            //Draws the cell itself with the given colors and location.
            drawDataCell(table.getCell(i, j).getCellColor(), table.getCell(i, j).getBorderColor(),
                    x + table.getRows().get(i).getCellPosition(j),
                    y + table.getRowPosition(i),
                    table.getCell(i, j).getWidth(), table.getRows().get(i).getHeight(), contents);
            contents.endMarkedContent();
            currentElem = addContentToParent(COSName.ARTIFACT, StandardStructureTypes.P, pages.get(pageIndex), currentElem);
            contents.close();
            //Draw the cell's text as a P structure element
            contents = new PDPageContentStream(
                    pdf, pages.get(pageIndex), PDPageContentStream.AppendMode.APPEND, false);
            setNextMarkedContentDictionary(COSName.P.getName());
            contents.beginMarkedContent(COSName.P, PDPropertyList.create(currentMarkedContentDictionary));
            //... Code to draw actual text...//
            //End the marked content and append it's P structure element to the containing TD structure element.
            contents.endMarkedContent();
            addContentToParent(COSName.P, null, pages.get(pageIndex), currentElem);
            contents.close();