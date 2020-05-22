if (strCmd.equals("Start")) {
            m_cCanvas.init();
            m_cSMsg = "c = " + Double.toString(m_dReal) + " + " + "j*" + Double.toString(m_dImag);
            m_bRunning = true;
            this.run();   // added call run method.
        } else if (aActionEvent.getSource() == m_cTReal) {