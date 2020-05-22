static int m_w = 1337;      // Choose initialization value, must not be zero
static int m_z = 123123;    // Choose initialization value, must not be zero

int GetRandom() 
{
    m_z = 36969 * (m_z & 65535) + (m_z >> 16);
    m_w = 18000 * (m_w & 65535) + (m_w >> 16);
    return (m_z << 16) + m_w;  /* 32-bit result */
}