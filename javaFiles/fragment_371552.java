try {

            serialPort.removeEventListener();
            serialPort.close();            
            in.close();
            out.close();
        } catch (IOException ex) {
            // don't care
        }
        // Close the port.
        serialPort.close();
    }