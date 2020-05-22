/**
 * This method returns an empty array.
 * The column position mapping strategy assumes that there is no header, and
 * thus it also does not write one, accordingly.
 * @return An empty array
 */
@Override
public String[] generateHeader() {
    return new String[0];
}