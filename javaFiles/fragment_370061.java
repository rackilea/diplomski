package org.sdms

import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class CliAddr extends HttpServlet {
    override def doGet(req: HttpServletRequest, resp: HttpServletResponse) {
        resp.getWriter.print(CLIRunner.listener.getInetAddress.getHostAddress)
    }
}