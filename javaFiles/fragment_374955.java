<display:table export="true" sort="list" id="productTable" name="products" pagesize="3"
                                cellpadding="5px" cellspacing="5px" style="margin-top:20px;">    
<display:column title="Product Image" media="html">
    <img alt="<s:property value="#attr.productTable.productName"/>" src="../uploaded_images/<s:property value="#attr.productTable.productImagesFileName"/>" >
    </display:column>

</display:table>