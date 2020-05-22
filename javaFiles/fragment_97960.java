func loadFull(name string) ([]byte, error) {
    f, errOpen := asset.Open(name)
    if errOpen != nil {
        return nil, errOpen
    }
    defer f.Close()
    buf, errRead := ioutil.ReadAll(f)
    if errRead != nil {
        return nil, errRead
    }
    log.Printf("loaded: %s (%d bytes)", name, len(buf))
    return buf, nil
}