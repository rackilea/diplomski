Element myOuterDiv = myDocument.select("div").first();

for (TextNode textNode : myOuterDiv.textNodes()) {
    textNode.remove();
}

System.out.println(myOuterDiv);