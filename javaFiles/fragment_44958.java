<aui:input model="<%= User.class %>"
        name="firstName"
        showRequiredLabel=""
        label="First Name <span style='color: red;'>*</span>"
        value="<%=user.getFirstName() %>">
</aui:input>

<!--
or else you can also include a CSS Class as <span class="required">*</span> 
then you would need to add a style as:
-->

<style>

    .required {
        color: red;
    }

</style>