EventHandler handler = myEventHandlers;
if (handler != null)
{
    // You could pass in a different "sender" and "args" of course
    handler(this, EventArgs.Empty);
}