UIManager.LookAndFeelInfo[] lookAndFeelInfos = UIManager.getInstalledLookAndFeels();
    for (int i = 0; i < lookAndFeelInfos.length; i++) {
        UIManager.LookAndFeelInfo lookAndFeelInfo = lookAndFeelInfos[i];

        //
        // Get the name of the look and feel
        //
        String name = lookAndFeelInfo.getName();
        System.out.println("name = " + name);

        //
        // Get the implementation class for the look and feel
        //
        String className = lookAndFeelInfo.getClassName();
        System.out.println("className = " + className);
    }