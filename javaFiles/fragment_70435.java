...
Some some = form().bindFromRequest().get();
if (some.id == null){
    some.save();
} else {
    some.update(some.id)
}