this.myFormElement.observe('change', this.onChange.bindAsEventListener(this));

...

onChange: function(event) {
    this.myFormElement.form.request({
           onSuccess: this.afterFormSubmitted.bind(this)
    });
},

afterFormSubmitted: function() {
   this.formInjector.trigger();
}