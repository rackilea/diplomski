int system(const char *cmd) {
    if (fork() == 0) {
        execl("/bin/sh", "-c", cmd);
        _exit(1);
    }
    int result;
    wait(&result);
    return WEXITSTATUS(result);
}