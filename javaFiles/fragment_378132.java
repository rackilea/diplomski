// get the ast rewriter
final ASTRewrite rewriter = ASTRewrite.create(ast);
// get the current document source
final Document document = new Document(unit.getSource());
// compute the edits you have made to the compilation unit
final TextEdit edits = rewriter.rewriteAST();
// apply the edits to the document
edits.apply(document);
// get the new source
String newSource = document.get();
// now write this source to some other file.