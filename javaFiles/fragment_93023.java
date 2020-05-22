public final class ArticleFilter
    implements Predicate<gestionstock.Article>
{
    private final Pattern pattern;

    public ArticleFilter(final String regex)
    {
        pattern = Pattern.compile(regex);
    }

    @Override
    public boolean apply(final gestionstock.Article input)
    {
        return pattern.matcher(input.getDesArt()).find();
    }
}