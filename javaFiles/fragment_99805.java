docNode = com.mathworks.xml.XMLUtils.createDocument('root');
domImpl = docNode.getImplementation();
doctype = domImpl.createDocumentType('root', 'SYSTEM', 'root.dtd');
docNode.appendChild(doctype);

root = docNode.getDocumentElement;

child = docNode.createElement('child');
child.appendChild(docNode.createTextNode('Hello World!'));
root.appendChild(child);

xmlwrite(docNode)