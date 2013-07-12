
package org.alfresco.integrations.openfire.user;


import org.alfresco.integrations.openfire.user.excpetions.IllegalArgumentException;
import org.alfresco.integrations.openfire.user.excpetions.RequestNotAuthorised;
import org.alfresco.integrations.openfire.user.excpetions.SharedGroupException;
import org.alfresco.integrations.openfire.user.excpetions.UserAlreadyExistsException;
import org.alfresco.integrations.openfire.user.excpetions.UserNotFoundException;
import org.alfresco.integrations.openfire.user.excpetions.UserServiceDisabled;


public interface OpenFireUserService
{
    public boolean addUser(String username, String password, String name, String email)
        throws IllegalArgumentException,
            UserNotFoundException,
            UserAlreadyExistsException,
            RequestNotAuthorised,
            UserServiceDisabled,
            SharedGroupException;


    public boolean deleteUser(String username)
        throws IllegalArgumentException,
            UserNotFoundException,
            UserAlreadyExistsException,
            RequestNotAuthorised,
            UserServiceDisabled,
            SharedGroupException;


    public boolean addRoster(String username, String jid, String name)
        throws IllegalArgumentException,
            UserNotFoundException,
            UserAlreadyExistsException,
            RequestNotAuthorised,
            UserServiceDisabled,
            SharedGroupException;
}
