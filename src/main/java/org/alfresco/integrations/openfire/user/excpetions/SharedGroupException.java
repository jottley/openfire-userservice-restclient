
package org.alfresco.integrations.openfire.user.excpetions;


/**
 * Roster item can not be added/deleted to/from a shared group for operations with roster.
 * 
 * @author jottley
 * 
 */
public class SharedGroupException
    extends RuntimeException
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;


    public SharedGroupException()
    {
        super("Roster item can not be added/deleted to/from a shared group for operations with roster.");
    }

}
