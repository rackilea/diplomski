package com.foo.test;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.cert.CertificateException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.foo.KeyStoreService;

@PrepareForTest(KeyStoreService.class)
@RunWith(PowerMockRunner.class)
public class TestKeyStore {

    @Test
    public void test1() throws KeyStoreException, NoSuchProviderException, NoSuchAlgorithmException, CertificateException, IOException{
        PowerMockito.mockStatic(KeyStore.class);
        KeyStore keyStoreMock = PowerMockito.mock(KeyStore.class);
        KeyStoreService kss = new KeyStoreService();
        PowerMockito.when(KeyStore.getInstance(Matchers.anyString(), Matchers.anyString())).thenReturn(keyStoreMock);
        Mockito.doNothing().when(keyStoreMock).load(Mockito.any(InputStream.class), Mockito.any(char[].class));
        kss.load();
    }
}