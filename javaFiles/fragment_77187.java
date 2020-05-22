package de.scrum_master.aspect;

import org.apache.commons.codec.binary.Base64;

public aspect Base64Manipulator {
    byte[] around() : execution(byte[] Base64.decodeBase64(byte[])) {
        System.out.println(thisJoinPoint);
        byte[] result = proceed();
        for (int i = 0; i < result.length; i++) {
            if (result[i] == 'o')
                result[i] = '0';
        }
        return result;
    }
}