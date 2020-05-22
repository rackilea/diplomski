// application
main() {
   for ( device in list_devices() ) {
      switch ( device.class ) {
         ....
      }
   }
}

// stub
list_devices() {
   for ( device = first; device != null; device += *cur )
      yield device;       
}
first: // drivers follow

// drivers/foo
dev_foo: .long dev_foo_end - . // size
....
dev_foo_end

// drivers/bar
dev_bar: .long dev_bar_end - .
....
dev_bar_end