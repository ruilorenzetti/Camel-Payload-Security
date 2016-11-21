package de.bit.camel.security.crypto;

import java.io.InputStream;
import java.security.KeyStore;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;

/**
 * Creates a simple keystore:<br/>
 * <code>keytool -genkey -alias hr -keystore hrStore.jks -validity 365 -storepass hrStore -storetype jceks</code>
 * 
 * For XMLSecurity (not loaded via this class):<br/>
 * <code>keytool -genkey -alias sac -keystore sacStore.jks -validity 365 -storepass sacStore -keyAlg RSA</code>
 * 
 * @author Dominik Schadow
 */
public class KeystoreFactory implements FactoryBean<KeyStore>, InitializingBean {
    private char[] password;
    private Resource location;
    private KeyStore keystore;

    public void setPassword(String password) {
        this.password = password.toCharArray();
    }

    public void setLocation(Resource location) {
        this.location = location;
    }

    @Override
    public KeyStore getObject() throws Exception {
        return keystore;
    }

    @Override
    public Class<KeyStore> getObjectType() {
        return KeyStore.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
    
    @Override
    public void afterPropertiesSet() throws Exception {
        keystore = KeyStore.getInstance("jceks");
        
        InputStream is = null;
        
        try {
            is = location.getInputStream();
            keystore.load(is, password);
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }
}
