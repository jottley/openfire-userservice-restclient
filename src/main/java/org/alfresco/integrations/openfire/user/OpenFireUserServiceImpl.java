
package org.alfresco.integrations.openfire.user;


import java.util.HashMap;
import java.util.Map;

import org.alfresco.integrations.openfire.user.excpetions.IllegalArgumentException;
import org.alfresco.integrations.openfire.user.excpetions.InvalidSetupException;
import org.alfresco.integrations.openfire.user.excpetions.RequestNotAuthorised;
import org.alfresco.integrations.openfire.user.excpetions.SharedGroupException;
import org.alfresco.integrations.openfire.user.excpetions.UserAlreadyExistsException;
import org.alfresco.integrations.openfire.user.excpetions.UserNotFoundException;
import org.alfresco.integrations.openfire.user.excpetions.UserServiceDisabled;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;


public class OpenFireUserServiceImpl
    implements OpenFireUserService
{

    private RestTemplate restTemplate = new RestTemplate(new SimpleClientHttpRequestFactory());
    private String       secret;
    private String       xmppServer;


    public void setRestTemplate(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }


    public void setSecret(String secret)
    {
        this.secret = secret;
    }


    public void setXmppServer(String xmppServer)
    {
        this.xmppServer = xmppServer;
    }


    @Override
    public boolean addUser(String username, String password, String name, String email)
        throws IllegalArgumentException,
            UserNotFoundException,
            UserAlreadyExistsException,
            RequestNotAuthorised,
            UserServiceDisabled,
            SharedGroupException
    {
        boolean success;

        Map<String, String> params = new HashMap<String, String>();
        params.put("type", "add");
        params.put("secret", secret);
        params.put("username", username);
        params.put("password", password);
        params.put("name", name);
        params.put("email", email);

        String response = get(xmppServer + OpenFireUserConstants.ADD, params);
        success = response.contains(Response.OK) ? true : Response.responseException(Response.getError(response));

        return success;
    }


    @Override
    public boolean deleteUser(String username)
        throws IllegalArgumentException,
            UserNotFoundException,
            UserAlreadyExistsException,
            RequestNotAuthorised,
            UserServiceDisabled,
            SharedGroupException
    {
        boolean success;

        Map<String, String> params = new HashMap<String, String>();
        params.put("type", "delete");
        params.put("secret", secret);
        params.put("username", username);

        String response = get(xmppServer + OpenFireUserConstants.DELETE, params);
        success = response.contains(Response.OK) ? true : Response.responseException(Response.getError(response));

        return success;
    }


    public boolean updateUser(String username, String password, String name, String email)
        throws IllegalArgumentException,
            UserNotFoundException,
            UserAlreadyExistsException,
            RequestNotAuthorised,
            UserServiceDisabled,
            SharedGroupException
    {
        boolean updated;

        Map<String, String> params = new HashMap<String, String>();
        params.put("type", "update");
        params.put("secret", secret);
        params.put("username", username);
        params.put("password", password);
        params.put("name", name);
        params.put("email", email);

        String response = get(xmppServer + OpenFireUserConstants.ADD, params);
        updated = response.contains(Response.OK) ? true : Response.responseException(Response.getError(response));

        return updated;
    }


    public boolean addRoster(String username, String jid, String name)
        throws IllegalArgumentException,
            UserNotFoundException,
            UserAlreadyExistsException,
            RequestNotAuthorised,
            UserServiceDisabled,
            SharedGroupException
    {
        boolean success;

        Map<String, String> params = new HashMap<String, String>();
        params.put("type", "add_roster");
        params.put("secret", secret);
        params.put("username", username);
        params.put("jid", jid);
        params.put("name", name);
        params.put("subscription", String.valueOf(3));

        String response = get(xmppServer + OpenFireUserConstants.ADD_ROSTER, params);
        success = response.contains(Response.OK) ? true : Response.responseException(Response.getError(response));

        return success;
    }


    public boolean updateRoster(String username, String jid, String name)
        throws IllegalArgumentException,
            UserNotFoundException,
            UserAlreadyExistsException,
            RequestNotAuthorised,
            UserServiceDisabled,
            SharedGroupException
    {
        boolean success;

        Map<String, String> params = new HashMap<String, String>();
        params.put("type", "update_roster");
        params.put("secret", secret);
        params.put("username", username);
        params.put("jid", jid);
        params.put("name", name);
        params.put("subscription", String.valueOf(3));

        String response = get(xmppServer + OpenFireUserConstants.ADD_ROSTER, params);
        success = response.contains(Response.OK) ? true : Response.responseException(Response.getError(response));

        return success;
    }


    private String get(String url, Map<String, String> params)
    {
        if (secret == null)
        {
            throw new InvalidSetupException("Secret not Provided");
        }

        if (xmppServer == null)
        {
            throw new InvalidSetupException("Server URL not Provided");
        }

        return restTemplate.getForObject(url, String.class, params);
    }
}
