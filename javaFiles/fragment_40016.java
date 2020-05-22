final class Wrapper {

    @SerializedName("id")
    @Expose
    private final String id = null;

    @SerializedName("games")
    @Expose
    private final List<String> games = null;

    @SerializedName("definition")
    @Expose
    private final FormulaDefinition formulaDefinition = null;

    private Wrapper() {
    }

    @Override
    public String toString() {
        return new StringBuilder("Wrapper{")
                .append("id='").append(id)
                .append("', games=").append(games)
                .append(", formulaDefinition=").append(formulaDefinition)
                .append('}')
                .toString();
    }

}