oracleContainer.copyFileToContainer(
        MountableFile.forClasspathResource("/helper/wait_check.sh"),
        "/wait_check.sh");
oracleContainer.copyFileToContainer(
        MountableFile.forClasspathResource("/helper/check_db_user.sh"),
        "/check_db_user.sh");

try {
    Container.ExecResult result = oracleContainer.execInContainer("./wait_check.sh");
    log.debug(result.getStdout());
} catch (IOException | InterruptedException e) {
    log.error(e.getMessage());
}