TurnLightOn (cmd) {
    history = getHistory(cmd.lightId)
    if (history.isEmpty) {
        history.append(LightCreatedEvent.from(cmd))
    }
    history.append(LightTurnedOnEvent.from(cmd))
    save(cmd.lightId, history)
}