
package org.alfresco.integrations.openfire.user;


import java.io.Serializable;

import org.alfresco.integrations.openfire.user.excpetions.IllegalArgumentException;
import org.alfresco.integrations.openfire.user.excpetions.RequestNotAuthorised;
import org.alfresco.integrations.openfire.user.excpetions.SharedGroupException;
import org.alfresco.integrations.openfire.user.excpetions.UserAlreadyExistsException;
import org.alfresco.integrations.openfire.user.excpetions.UserNotFoundException;
import org.alfresco.integrations.openfire.user.excpetions.UserServiceDisabled;


public class Response
    implements Serializable
{

    private static final long  serialVersionUID           = 375401193163881039L;

    public static final String OK                         = "ok";
    public static final String IllegalArgumentException   = "IllegalArgumentException";
    public static final String UserNotFoundException      = "UserNotFoundException";
    public static final String UserAlreadyExistsException = "UserAlreadyExistsException";
    public static final String RequestNotAuthorised       = "RequestNotAuthorised";
    public static final String UserServiceDisabled        = "UserServiceDisabled";
    public static final String SharedGroupException       = "SharedGroupException";


    public static String getError(String response)
    {
        return stripErrorTags(response);
    }


    private static String stripErrorTags(String response)
    {
        return response.replaceFirst("<error>", "").replaceFirst("</error>", "");
    }


    public static boolean responseException(String response)
    {
        switch (response)
        {
            case Response.IllegalArgumentException:
                throw new IllegalArgumentException();
            case Response.UserNotFoundException:
                throw new UserNotFoundException();
            case Response.UserAlreadyExistsException:
                throw new UserAlreadyExistsException();
            case Response.RequestNotAuthorised:
                throw new RequestNotAuthorised();
            case Response.UserServiceDisabled:
                throw new UserServiceDisabled();
            case Response.SharedGroupException:
                throw new SharedGroupException();
            default:
                return false;
        }
    }

}
