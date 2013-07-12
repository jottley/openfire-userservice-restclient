
package org.alfresco.integrations.openfire.user.excpetions;


/**
 * One of the parameters passed in to the User Service was bad.
 * 
 * @author jottley
 * 
 */
public class IllegalArgumentException
    extends RuntimeException
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;


    public IllegalArgumentException()
    {
        super("One of the parameters passed in to the User Service was bad.");
    }

}
