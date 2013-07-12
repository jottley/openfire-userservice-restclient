
package org.alfresco.integrations.openfire.user.excpetions;


/**
 * The User Service is currently set to disabled in the Admin Console.
 * 
 * @author jottley
 * 
 */
public class UserServiceDisabled
    extends RuntimeException
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;


    public UserServiceDisabled()
    {
        super("The User Service is currently set to disabled in the Admin Console.");
    }

}
