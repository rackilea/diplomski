/**
 * Set the video play rate.
 * <p>
 * Some media protocols are not able to change the rate.
 *
 * @param rate rate, where 1.0 is normal speed, 0.5 is half speed, 2.0 is double speed and so on
 * @return -1 on error, 0 on success
 */
int setRate(float rate);