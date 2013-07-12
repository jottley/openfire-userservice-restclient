
package org.alfresco.integrations.openfire.user.excpetions;


/**
 * A user with the same name as the user about to be added, already exists. For 'add_roster' operation, roster item with the same
 * JID already exists.
 * 
 * @author jottley
 * 
 */
public class UserAlreadyExistsException
    extends RuntimeException
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;


    public UserAlreadyExistsException()
    {
        super("A user with the same name as the user about to be added, already exists. For 'add_roster' operation, roster item with the same JID already exists.");
    }

}
