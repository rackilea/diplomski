when(abilityRepository.findRandomAbilitySetForEventLogic(eventLogic, pageableForSingleResult)).thenReturn(ability_ids());

...

private List<AbilitySetId> ability_ids() {
    return new ImmutableList.of(...);
}