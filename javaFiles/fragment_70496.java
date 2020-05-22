class Handler<T, U extends Identity<T>>
{
    Handler(U value) {
        Util.handle(value);
    }
}