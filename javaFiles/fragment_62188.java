//Add a radio button widget.
            if (!table.getCell(i, j).getRbVal().isEmpty()) {
                PDStructureElement fieldElem = new PDStructureElement(StandardStructureTypes.FORM, currentElem);
                radioWidgets.add(addRadioButton(
                        x + table.getRows().get(i).getCellPosition(j) -
                                radioWidgets.size() * 10 + table.getCell(i, j).getWidth() / 4,
                        y + table.getRowPosition(i),
                        table.getCell(i, j).getWidth() * 1.5f, 20,
                        radioValues, pageIndex, radioWidgets.size()));
                fieldElem.setPage(pages.get(pageIndex));
                COSArray kArray = new COSArray();
                kArray.add(COSInteger.get(currentMCID));
                fieldElem.getCOSObject().setItem(COSName.K, kArray);
                addWidgetContent(annotationRefs.get(annotationRefs.size() - 1), fieldElem, StandardStructureTypes.FORM, pageIndex);
            }

//Add a text field in the current cell.
            if (!table.getCell(i, j).getTextVal().isEmpty()) {
                PDStructureElement fieldElem = new PDStructureElement(StandardStructureTypes.FORM, currentElem);
                addTextField(x + table.getRows().get(i).getCellPosition(j),
                        y + table.getRowPosition(i),
                        table.getCell(i, j).getWidth(), table.getRows().get(i).getHeight(),
                        table.getCell(i, j).getTextVal(), pageIndex);
                fieldElem.setPage(pages.get(pageIndex));
                COSArray kArray = new COSArray();
                kArray.add(COSInteger.get(currentMCID));
                fieldElem.getCOSObject().setItem(COSName.K, kArray);
                addWidgetContent(annotationRefs.get(annotationRefs.size() - 1), fieldElem, StandardStructureTypes.FORM, pageIndex);
            }