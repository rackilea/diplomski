require 'java'

Dir["./Java/jetty-6.1.18/lib/*.jar"].each { |jar| require jar }
Dir["./Java/lib/jsdk2.1/javax/*.jar"].each { |jar| require jar }

include_class 'javax.servlet.http.HttpServlet'
include_class 'org.mortbay.jetty.Server'
include_class 'org.mortbay.jetty.servlet.Context'
include_class 'org.mortbay.jetty.servlet.ServletHolder'

def main
  server = Server.new(8080)
  context = Context.new(server, '/', 0)
  servlet = TestServlet.new()
  holder = ServletHolder.new(servlet)
  context.addServlet(holder, '/')
  server.start()
end

class TestServlet < HttpServlet

  def doPost(request, response)
    input = request.getParameter('input')
    response.writer.println("
    <html>
     <head><title>Output</title></head>
     <body>
     Raw input: <pre>#{input}</pre> 
     </body>
    </html>")
    request.handled = true
  end

end

main