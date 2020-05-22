BattleManager bm = BattleManager.getInstance(user1, user2);

onSpellClicked() {
   bm.castSpell(spellId, user1, callback)
}

BasicCallback callback = new BasicCallback() {
    @Override
    onComplete() {
        if (MyInfoFragment.this.isVisible()) {
            [Update UI]
        }
    }
};