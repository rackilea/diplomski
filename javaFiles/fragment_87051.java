exec('java -jar ' + './server/spigot-1.13.2.jar', { cwd: './test-server' }, (err, stdout, stderr) => {
if (err)
    throw err;
console.log(stdout);
console.log(stderr);
});