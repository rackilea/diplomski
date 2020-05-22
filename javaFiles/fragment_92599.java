25    // no surprise here

25    // ChildOne does not define its own variable so it uses the Parent's

99    // As in the earlier example the variable is getting shadowed


66    // we just changed the variable value so this looks normal

66    // even though it was the Parent's variable we changed
      //   the Child shares it too

99    // Since ChildTwo's variable is shadowing the Parent value it has not changed.


123   // 123? But we changed the original ChildOne...

456   // Again we modified the other object but since they share
      //   the same static variable; changing one also changes the other.