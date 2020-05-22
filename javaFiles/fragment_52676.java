Frame myFrame = new JFrame();
// Make sure you add your elements into the frame's content pane by
myFrame.getContentPane(component);
ComponentTreeBuilder cmpBuilder = new ComponentTreeBuilder();
cmpBuilder.visitComponent(myFrame);
Map<String, Component> components = cmpBuilder.getComponentsTree(); 
// All components should now be in components hashmap