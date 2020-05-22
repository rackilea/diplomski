expected_message_id = 0
while (true) {
    m = receive_message(queue)
    if (m.id == expected_message_id) {
        process(m)
        m.acknowledge()
        expected_message_id++
    } else {
        republish_to_queue(m, queue) // might use old exchange, or pick a new-one for this type of back-channel
    }
}