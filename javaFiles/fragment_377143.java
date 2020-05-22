// Open up the readers/writers

// Prime the queue with the first few line of the file.
// Need to add safeguard to protect against small files!!
queue.push(br.readLine());
queue.push(br.readLine());
queue.push(br.readLine());

while ((line = br.readLine()) != null) {
    String lineConcat = line  + "\n";

    queue.push(lineConcat);

    String oldLine = queue.pop();

    if (line.startsWith("\""+name+"\"")) {
         oldLine = < Modify oldLine >
    }

    bw.write(oldLine)
}

// Empty the queue
bw.write(queue.pop());
bw.write(queue.pop());
bw.write(queue.pop());

// Close the readers/writer