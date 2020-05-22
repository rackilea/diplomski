const { spawn } = require('child_process');

const mc = spawn('java', ['-Xmx1024M', '-Xms1024M', '-jar', './server/spigot-1.13.2.jar', 'nogui'], { cwd: './new-server/' });


mc.stdout.on('data', (data) => {
  console.log(`stdout: ${data}`);
});

mc.stderr.on('data', (data) => {
  console.log(`stderr: ${data}`);
});

mc.on('close', (code) => {
  console.log(`child process exited with code ${code}`);
});