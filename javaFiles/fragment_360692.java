<applet name="jZebra" code="jzebra.PrintApplet.class" archive="${pageContext.request.contextPath}/jzebra.jar" width="1" height="1">
     <param name="printer" value="zebra">
</applet>

<script type="text/javascript">
   function printZebra(data) {
       var applet = document.jZebra;
       if (applet != null) {
          applet.append(data);
          applet.print();
    }
   }
</script>