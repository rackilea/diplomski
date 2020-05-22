case 0x27: /*      DAA */
    {
        int tmp = m_A;

        if ( ! ( m_F & FLAG_N ) ) {
            if ( ( m_F & FLAG_H ) || ( tmp & 0x0F ) > 9 )
                tmp += 6;
            if ( ( m_F & FLAG_C ) || tmp > 0x9F )
                tmp += 0x60;
        } else {
            if ( m_F & FLAG_H ) {
                tmp -= 6;
                if ( ! ( m_F & FLAG_C ) )
                    tmp &= 0xFF;
            }
            if ( m_F & FLAG_C )
                    tmp -= 0x60;
        }
        m_F &= ~ ( FLAG_H | FLAG_Z );
        if ( tmp & 0x100 )
            m_F |= FLAG_C;
        m_A = tmp & 0xFF;
        if ( ! m_A )
            m_F |= FLAG_Z;
    }
    break;