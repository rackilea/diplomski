Element anotherElement  = (Element)document.getElementsByTagName("Empresa").item(0);
    Element newTag = document.createElement("Signature");
    Element childElem1=document.createElement("SignedInfo");
    Element childElem2=document.createElement("KeyInfo");
    newTag.appendChild(childElem1);newTag.appendChild(childElem2);
    anotherElement.getParentNode().insertBefore(newTag, anotherElement);