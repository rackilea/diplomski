interface Advanced {}

@GroupSequence({Default.class, Advanced.class})
interface Sequence {}

class Foo {
    @Size(max = 1)
    @Valid
    private List<Bar> bars;
}

class Bar {
    @NotBlank(groups = Advanced.class)
    private String snafu;
}

Foo foo = new Foo();
foo.bars = new ArrayList<Bar>();
foo.bars.add(new Bar());
foo.bars.add(new Bar());

Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
Set<ConstraintViolation<Foo>> constraintViolations = validator.validate(foo, Sequence.class)