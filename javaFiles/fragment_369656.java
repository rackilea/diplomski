class Progress_Bar extends JPanel implements Runnable {
    // .....

    public void Set_Progress(int Progress) {
        if (Progress == 1 || (this.Progress < Progress && Progress <= 100)) {
            this.Progress = Progress;    // ****** being called off the EDT
            b.paintImmediately(0, 0, b.getWidth(), b.getHeight());  // ***** Don't do this
            Out("        Progress = " + Progress + " %");
        }
        // .....
    }

    public void run() {
        try {
            while (Progress <= 100) {
                if ((Progress == 0 || Progress == 50 || Progress == 100 || Do_Step_B)
                        && Last_Progress != Progress) {

                    // ***** called off the EDT -- don't do this
                    b.setValue(Progress);
                    // revalidate();
                    b.paintImmediately(0, 0, b.getWidth(), b.getHeight()); // **** and don't do this
                    Last_Progress = Progress;
                }
                Thread.sleep(200); // Delay the thread
                Do_Step_B = (Started_B && (counter++ % Unit_Size == 0));
                if (Progress < 100 && Do_Step_B)
                    Progress++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // .......
}