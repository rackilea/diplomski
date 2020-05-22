/**
 * Constructs an <code>ItemEvent</code> object.
 * <p> This method throws an
 * <code>IllegalArgumentException</code> if <code>source</code>
 * is <code>null</code>.
 *
 * @param source The <code>ItemSelectable</code> object
 *               that originated the event
 * @param id           The integer that identifies the event type.
 *                     For information on allowable values, see
 *                     the class description for {@link ItemEvent}
 * @param item   An object -- the item affected by the event
 * @param stateChange  An integer that indicates whether the item was
 *               selected or deselected.
 *                     For information on allowable values, see
 *                     the class description for {@link ItemEvent}
 * @throws IllegalArgumentException if <code>source</code> is null
 * @see #getItemSelectable()
 * @see #getID()
 * @see #getStateChange()
 */
public ItemEvent(ItemSelectable source, int id, Object item, int stateChange) {
    super(source, id);
    this.item = item;
    this.stateChange = stateChange;
}