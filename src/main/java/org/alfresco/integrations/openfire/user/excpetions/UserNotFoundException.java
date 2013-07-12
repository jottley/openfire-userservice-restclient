
package org.alfresco.integrations.openfire.user.excpetions;


/**
 * No user of the name specified, for a delete or update operation, exists on this server. For 'update_roster' operation, roster
 * item to be updated was not found.
 * 
 * @author jottley
 * 
 */

public class UserNotFoundException
    extends RuntimeException
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;


    public UserNotFoundException()
    {
        super("No user of the name specified, for a delete or update operation, exists on this server. For 'update_roster' operation, roster item to be updated was not found.");
    }

}
