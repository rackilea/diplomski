/*
 * Delete the network in the supplicant config.
 *
 * This function is used instead of a sequence of removeNetwork()
 * and saveConfiguration().
 *
 * @param config the set of variables that describe the configuration,
 *            contained in a {@link WifiConfiguration} object.
 * @hide
 */

public void forgetNetwork(int netId) {
    if (netId < 0) {
        return;
    }
    mAsyncChannel.sendMessage(CMD_FORGET_NETWORK, netId);
}