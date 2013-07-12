
package org.alfresco.integrations.openfire.user.excpetions;


/**
 * The supplied secret does not match the secret specified in the Admin Console or the requester is not a valid IP address.
 * 
 * @author jottley
 * 
 */
public class RequestNotAuthorised
    extends RuntimeException
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;


    public RequestNotAuthorised()
    {
        super("The supplied secret does not match the secret specified in the Admin Console or the requester is not a valid IP address.");
    }

}
