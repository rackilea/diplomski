const spawn = require('child_process').spawn;
const child = spawn('java', ['HelloWorld'], {
    stdio: ['pipe', process.stdout, process.stderr]
});

process.stdin.pipe(child.stdin);
setTimeout(() => {
    child.stdin.write('tratata\n');
}, 1000);