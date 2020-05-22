String responseToClient= "<tdcp><cmd><ack cmd=”Init”><panelistid>3849303</panelistid></ack></cmd></tdcp>";

httpServletResponse.setStatus(HttpServletResponse.SC_OK);
httpServletResponse.getWriter().write(responseToClient);
httpServletResponse.getWriter().flush();
httpServletResponse.getWriter().close();