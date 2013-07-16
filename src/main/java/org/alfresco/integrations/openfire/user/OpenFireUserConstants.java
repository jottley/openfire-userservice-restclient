
package org.alfresco.integrations.openfire.user;


public interface OpenFireUserConstants
{

    static final String  BASE          = "/plugins/userService/userservice?";
    public static String ADD           = BASE
                                         + "type={type}&secret={secret}&username={username}&password={password}&name={name}&email={email}";
    public static String DELETE        = BASE + "type={type}&secret={secret}&username={username}";
    public static String UPDATE        = BASE
                                         + "type={type}&secret={secret}t&username={username}&password={password}&name={name}&email={email}";
    public static String ADD_ROSTER    = BASE
                                         + "type={type}&secret={secret}&username={username}&item_jid={jid}&name={name}&subscription={subscription}";
    public static String UPDATE_ROSTER = ADD_ROSTER;

}
