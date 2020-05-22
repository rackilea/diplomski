package com.example

import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class Servlet extends HttpServlet {

    override def doGet(req: HttpServletRequest, resp: HttpServletResponse) = {
        if (!CLIThread.isAlive) {
            try {
                CLIThread.start
            }
            catch {
                case _ => resp.getOutputStream().println("Error: thread state is, " + CLIThread.getState)
            }
        }
        resp.getOutputStream().println(CLIThread.pool)
    }

    override def destroy(): Unit = {
        super.destroy()
        CLIThread.shutdown
    }
}