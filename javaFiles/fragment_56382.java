<s:form id="myForm">
  <s:hidden name="modelNo" value="%{#attr.productId}"></s:hidden>  
  <s:hidden id="description" name="description" value="%{#attr.productName}"></s:hidden>
  <s:hidden id="price" name="price" value="%{#attr.listprice}"></s:hidden>
  <s:hidden id="action" name="action" value="Add"></s:hidden>
  <s:submit id="#submit" value="add to cart" cssClass="submit_button" theme="simple"></s:submit>
</s:form>

<script>
$("#submit").click(function(){
        var formData = $("#myForm").serialize(); //get all data from form
          //do the POST thingies
        $.ajax({
            type: "POST",
            url: "url_to_your_struts2_action",
            cache: false,
            data: formData,
            success: onSuccess,
            error: onError
        });

        return false;
});
</script>