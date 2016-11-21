package de.bit.camel.security.crypto;

import java.io.InputStream;
import java.security.Key;
import java.security.KeyStore;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;

/**
 * Creates a simple keystore:<br/>
 * <code>keytool -genseckey -keyalg AES -keysize 128 -alias hrSecretKey -keystore hrStore.jks -storepass hrStore -storetype jceks</code>
 * 
 * @author Dominik Schadow
 */
public class KeyFactory implements FactoryBean<Key>, InitializingBean {
    private Logger logger = Logger.getLogger(KeyFactory.class);
    private static Key aesKey = null;
    private char[] password;
    private Resource location;
    private char[] keyPassword;
    private String keyAlias;
    
    public void setPassword(String password) {
        this.password = password.toCharArray();
    }

    public void setLocation(Resource location) {
        this.location = location;
    }

    public void setKeyPassword(String keyPassword) {
        this.keyPassword = keyPassword.toCharArray();
    }

    public void setKeyAlias(String keyAlias) {
        this.keyAlias = keyAlias;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        try {
            KeyStore keystore = KeyStore.getInstance("jceks");
            InputStream is = location.getInputStream();
            keystore.load(is, password);
            
            aesKey = keystore.getKey(keyAlias, keyPassword);
        } catch (Exception ex) {
            logger.error(ex);
        }
    }

    @Override
    public Key getObject() throws Exception {
        return aesKey;
    }

    @Override
    public Class<Key> getObjectType() {
        return Key.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
