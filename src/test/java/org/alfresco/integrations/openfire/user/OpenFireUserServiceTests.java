
package org.alfresco.integrations.openfire.user;


import junit.framework.Assert;

import org.alfresco.integrations.openfire.user.OpenFireUserConstants;
import org.alfresco.integrations.openfire.user.OpenFireUserServiceImpl;
import org.alfresco.integrations.openfire.user.excpetions.IllegalArgumentException;
import org.alfresco.integrations.openfire.user.excpetions.RequestNotAuthorised;
import org.alfresco.integrations.openfire.user.excpetions.SharedGroupException;
import org.alfresco.integrations.openfire.user.excpetions.UserAlreadyExistsException;
import org.alfresco.integrations.openfire.user.excpetions.UserNotFoundException;
import org.alfresco.integrations.openfire.user.excpetions.UserServiceDisabled;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.match.RequestMatchers;
import org.springframework.test.web.client.response.ResponseCreators;
import org.springframework.web.client.RestTemplate;


public class OpenFireUserServiceTests
{
    static RestTemplate          restTemplate;
    static MockRestServiceServer mockServer;


    @Before
    public void runBeforeTest()
    {
        restTemplate = new RestTemplate();
        mockServer = MockRestServiceServer.createServer(restTemplate);
    }


    @After
    public void runAfterTest()
    {
        restTemplate = null;
        mockServer = null;
    }


    @Test
    public void addUserTest()
    {
        mockServer.expect(RequestMatchers.requestTo(Matchers.containsString(OpenFireUserConstants.BASE))).andRespond(ResponseCreators.withSuccess("<result>ok</result>", MediaType.TEXT_XML));

        OpenFireUserServiceImpl userService = new OpenFireUserServiceImpl();
        userService.setRestTemplate(restTemplate);
        userService.setSecret("the secret");
        userService.setXmppServer("http://localhost:9090");

        try
        {

            boolean added = userService.addUser("jottley", "password", "Jared Ottley", "jared.ottley@alfresco.com");
            Assert.assertEquals(true, added);
        }
        catch (RuntimeException re)
        {
            Assert.fail(re.getMessage());
        }
    }


    @Test
    public void deleteUserTest()
    {
        mockServer.expect(RequestMatchers.requestTo(Matchers.containsString(OpenFireUserConstants.BASE))).andRespond(ResponseCreators.withSuccess("<result>ok</result>", MediaType.TEXT_XML));

        OpenFireUserServiceImpl userService = new OpenFireUserServiceImpl();
        userService.setRestTemplate(restTemplate);
        userService.setSecret("the secret");
        userService.setXmppServer("http://localhost:9090");

        try
        {
            boolean deleted = userService.deleteUser("jottley");
            Assert.assertEquals(true, deleted);
        }
        catch (RuntimeException re)
        {
            Assert.fail(re.getMessage());
        }
    }


    @Test
    public void addRosterUserTest()
    {
        mockServer.expect(RequestMatchers.requestTo(Matchers.containsString(OpenFireUserConstants.BASE))).andRespond(ResponseCreators.withSuccess("<result>ok</result>", MediaType.TEXT_XML));

        OpenFireUserServiceImpl userService = new OpenFireUserServiceImpl();
        userService.setRestTemplate(restTemplate);
        userService.setSecret("the secret");
        userService.setXmppServer("http://localhost:9090");

        try
        {
            boolean deleted = userService.addRoster("jottley", "test@xmpp.alfresco.com", "Test");
            Assert.assertEquals(true, deleted);
        }
        catch (RuntimeException re)
        {
            Assert.fail(re.getMessage());
        }
    }


    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentExceptionTest()
    {
        mockServer.expect(RequestMatchers.requestTo(Matchers.containsString(OpenFireUserConstants.BASE))).andRespond(ResponseCreators.withSuccess("<error>IllegalArgumentException</error>", MediaType.TEXT_XML));

        OpenFireUserServiceImpl userService = new OpenFireUserServiceImpl();
        userService.setRestTemplate(restTemplate);
        userService.setSecret("the secret");
        userService.setXmppServer("http://localhost:9090");

        userService.addUser("jottley", "password", "Jared Ottley", "jared.ottley@alfresco.com");
    }


    @Test(expected = RequestNotAuthorised.class)
    public void requestNotAuthprosedTest()
    {
        mockServer.expect(RequestMatchers.requestTo(Matchers.containsString(OpenFireUserConstants.BASE))).andRespond(ResponseCreators.withSuccess("<error>RequestNotAuthorised</error>", MediaType.TEXT_XML));

        OpenFireUserServiceImpl userService = new OpenFireUserServiceImpl();
        userService.setRestTemplate(restTemplate);
        userService.setSecret("the secret");
        userService.setXmppServer("http://localhost:9090");

        userService.addUser("jottley", "password", "Jared Ottley", "jared.ottley@alfresco.com");
    }


    @Test(expected = SharedGroupException.class)
    public void sharedGroupExceptionTest()
    {
        mockServer.expect(RequestMatchers.requestTo(Matchers.containsString(OpenFireUserConstants.BASE))).andRespond(ResponseCreators.withSuccess("<error>SharedGroupException</error>", MediaType.TEXT_XML));

        OpenFireUserServiceImpl userService = new OpenFireUserServiceImpl();
        userService.setRestTemplate(restTemplate);
        userService.setSecret("the secret");
        userService.setXmppServer("http://localhost:9090");

        userService.addUser("jottley", "password", "Jared Ottley", "jared.ottley@alfresco.com");
    }


    @Test(expected = UserAlreadyExistsException.class)
    public void userAlreadyExistsExceptionTest()
    {
        mockServer.expect(RequestMatchers.requestTo(Matchers.containsString(OpenFireUserConstants.BASE))).andRespond(ResponseCreators.withSuccess("<error>UserAlreadyExistsException</error>", MediaType.TEXT_XML));

        OpenFireUserServiceImpl userService = new OpenFireUserServiceImpl();
        userService.setRestTemplate(restTemplate);
        userService.setSecret("the secret");
        userService.setXmppServer("http://localhost:9090");

        userService.addUser("jottley", "password", "Jared Ottley", "jared.ottley@alfresco.com");
    }


    @Test(expected = UserNotFoundException.class)
    public void userNotFoundExceptionTest()
    {
        mockServer.expect(RequestMatchers.requestTo(Matchers.containsString(OpenFireUserConstants.BASE))).andRespond(ResponseCreators.withSuccess("<error>UserNotFoundException</error>", MediaType.TEXT_XML));

        OpenFireUserServiceImpl userService = new OpenFireUserServiceImpl();
        userService.setRestTemplate(restTemplate);
        userService.setSecret("the secret");
        userService.setXmppServer("http://localhost:9090");

        userService.addUser("jottley", "password", "Jared Ottley", "jared.ottley@alfresco.com");
    }


    @Test(expected = UserServiceDisabled.class)
    public void userServiceDisabledTest()
    {
        mockServer.expect(RequestMatchers.requestTo(Matchers.containsString(OpenFireUserConstants.BASE))).andRespond(ResponseCreators.withSuccess("<error>UserServiceDisabled</error>", MediaType.TEXT_XML));

        OpenFireUserServiceImpl userService = new OpenFireUserServiceImpl();
        userService.setRestTemplate(restTemplate);
        userService.setSecret("the secret");
        userService.setXmppServer("http://localhost:9090");

        userService.addUser("jottley", "password", "Jared Ottley", "jared.ottley@alfresco.com");
    }

}
