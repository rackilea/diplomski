rc = zmq_recv (socket, message, flags);
int err = zmq_errno();
if (rc < 0 && err == EAGAIN) {
    rc = zmq_msg_close (message);
    err = zmq_errno();
    if (rc != 0) {
        raise_exception (env, err);
        return NULL;
    }
    return NULL;
}
if (rc < 0) {
    raise_exception (env, err);
    rc = zmq_msg_close (message);
    err = zmq_errno();
    if (rc != 0) {
        raise_exception (env, err);
        return NULL;
    }
    return NULL;
}
return message;