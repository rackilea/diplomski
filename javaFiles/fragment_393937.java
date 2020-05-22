Public XWPFDocument findAndReplaceToken (Map<String, Object> replacements,
        XWPFDocument document) {
    List<XWPFParagraph> paragraphs = document.getParagraphs();
    for (int i = 0; i < paragraphs.size(); i++) {
        XWPFParagraph paragraph = paragraphs.get(i);

        List<XWPFRun> runs = paragraph.getRuns();
        for (Map.Entry<String, Object> replPair : replacements
                .entrySet()) {
            String find = replPair.getKey();
            Object repl = replPair.getValue();
            TextSegement found =
                    paragraph.searchText(find, new PositionInParagraph());
            if (found != null) {
                if (repl instanceof String) {
                    replaceText(found, runs, find, repl);
                } else if (repl instanceof ArrayList<?>) {

                    Iterator<?> iterArrayList =
                            ((ArrayList) repl).iterator();

                    boolean isPassed = false;

                    while (iterArrayList.hasNext()) {
                        Object object = (Object) iterArrayList.next();

                        if (isPassed == false) {
                            replaceText(found, runs, find,
                                    object.toString());
                        } else {
                            XWPFRun run = paragraph.createRun();
                            run.addCarriageReturn();
                            run.setText(object.toString());
                        }

                        isPassed = true;
                    }
                }
            }
        }
    }
    return document;
}

private void replaceText(TextSegement found, List<XWPFRun> runs,
        String find, Object repl) {
    int biginRun = found.getBeginRun();
    int biginRun2 = found.getEndRun();
    if (found.getBeginRun() == found.getEndRun()) {
        // whole search string is in one Run
        XWPFRun run = runs.get(found.getBeginRun());
        String runText = run.getText(run.getTextPosition());
        String replaced = runText.replace(find, repl.toString());
        run.setText(replaced, 0);
    } else {
        // The search string spans over more than one Run
        // Put the Strings together
        StringBuilder b = new StringBuilder();
        for (int runPos = found.getBeginRun(); runPos <= found
                .getEndRun(); runPos++) {
            XWPFRun run = runs.get(runPos);
            b.append(run.getText(run.getTextPosition()));
        }
        String connectedRuns = b.toString();
        String replaced = connectedRuns.replace(find, repl.toString());

        // The first Run receives the replaced String of all
        // connected Runs
        XWPFRun partOne = runs.get(found.getBeginRun());
        partOne.setText(replaced, 0);
        // Removing the text in the other Runs.
        for (int runPos = found.getBeginRun() + 1; runPos <= found
                .getEndRun(); runPos++) {
            XWPFRun partNext = runs.get(runPos);
            partNext.setText("", 0);
        }
    }
}