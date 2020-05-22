<s:form action="clientAction" method="post" theme="css_xhtml">
    <s:select id="RegistrationType" name="type" label="Registration Type"
              list="{'Student', 'Faculty'}" emptyOption="false" />
  <s:div id="Student" cssStyle="display: none;">
    <s:textfield label="FirstName" name="s_fname"/>
    <s:textfield label="LastName" name="s_lname"/>
    <s:textfield label="UserName" name="s_username"/>
    <s:password label="Password" name="s_password"/>
    <s:textfield label="EmailId" name="s_email_id"/>
    <s:submit/>
  </s:div>

  <s:div id="Faculty" cssStyle="display: none;" >
    <s:textfield label="FirstName" name="fac_fname"/>
    <s:textfield label="LastName" name="fac_lname"/>
    <s:textfield label="UserName" name="fac_username"/>
    <s:password label="Password" name="fac_password"/>
    <s:textfield label="EmailId" name="fac_email"/>
    <s:textfield label="Course Name" name="course_name"/>
    <s:textfield label="Course Id" name="course_id"/>
    <s:submit/>
  </s:div>
</s:form>
<script type="text/javascript">
  $(document).ready(function(){
    $('#RegistrationType').change(function(){
      $('#'+this.value).css('display', 'block');
      if (this.value=='Student') $('#Faculty').css('display', 'none');
      else $('#Student').css('display', 'none');
    });
  });
</script>