$("#someForm").validate({
  rules:{
    'checklist.notes':{
      minlength:<s:property value="@my.package.constantClass@MIN_LENGHT" />,
      maxlength:<s:property value="@my.package.constantClass@MAX_LENGHT" />
    }
  }
});