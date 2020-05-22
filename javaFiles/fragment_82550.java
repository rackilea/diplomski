this.success = buildId.contains(args[0]) && args[2].equals("success");


...
// Assert
assertThat(this.success).isTrue();