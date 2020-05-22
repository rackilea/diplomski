// Build Fault Message Detail
        Document newDoc = DOMUtils.createDocument();
        Element exceptionDetail = newDoc.createElement("detail");

        Element esbFaultNode = newDoc.createElement(newException.getClass().getSimpleName());
        exceptionDetail.appendChild(esbFaultNode);

        Element faultTypeBeanNode = newDoc.createElement("ErrorType");
        faultTypeBeanNode.setTextContent(newFaultExceptionbean.getType().name());
        Element faultCodeBeanNode = newDoc.createElement("ErrorCode");
        faultCodeBeanNode.setTextContent(newFaultExceptionbean.getCode().toString());
        Element faultMessageBeanNode = newDoc.createElement("ErrorMessage");
        faultMessageBeanNode.setTextContent(newFaultExceptionbean.getMessage());

        esbFaultNode.appendChild(faultTypeBeanNode);
        esbFaultNode.appendChild(faultCodeBeanNode);
        esbFaultNode.appendChild(faultMessageBeanNode);


        // Set the fault detail
        newfault.setDetail(exceptionDetail);`