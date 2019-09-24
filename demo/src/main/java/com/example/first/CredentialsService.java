package com.example.first;

import java.net.URISyntaxException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponseSupport;

/**
 * Sample service to demonstrate storing and retrieval of secrets.
 * 
 * NOTE: We need to configure Vault and provide the Vault uri in the properties file.
 *
 */
@Service
public class CredentialsService {

    @Autowired
    private VaultTemplate vaultTemplate;

    /**
    *  To Secure Credentials
    * @param credentials
    * @return VaultResponse
    * @throws URISyntaxException
    */
    public void secureCredentials(Credentials credentials) throws URISyntaxException {

        vaultTemplate.write("credentials/myapp", credentials);
    }

    /**
     * To Retrieve Credentials
     * @return Credentials
     * @throws URISyntaxException
     */
    
//    public Credentials accessCredentials() throws URISyntaxException {
//    	VaultResponseSupport<Credentials> response = vaultTemplate.read("secret/foo", Credentials.class);
//        System.out.println(response.getData().getExcited());
//        System.out.println(response.getData().getName());
//        return response.getData();
//    }
    
	
	  public Credentials accessCredentials() throws URISyntaxException {
	  Credentials c=new Credentials();
	  VaultResponseSupport<Map<String, Object>> response =
	  vaultTemplate.read("secret/foo");
	  System.out.println("Excited"+response.getData().get("Excited"));
	  System.out.println("Name"+response.getData().get("Name")); 
	  System.out.println("keySet"+response.getData().keySet());
	  System.out.println("EntrySet"+response.getData().entrySet());
	  return c;
	  }

}
