ChromeDriver driver = new ChromeDriver();
html_content = """
<html>
     <head></head>
     <body>
         <div>
             Hello World =)
         </div>
     </body>
</html>
"""

driver.get("data:text/html;charset=utf-8," + html_content)