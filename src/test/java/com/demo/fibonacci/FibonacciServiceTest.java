package com.demo.fibonacci;

import static org.junit.Assert.*;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 *JUNIT TEST CLASS FOR TESTING REST SERVICE
 */
public class FibonacciServiceTest
{
    public static final URI BASE_URI = UriBuilder.fromUri( "http://localhost" ).port( 8080 ).build();
    private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception
    {

        ResourceConfig rc = new ResourceConfig( FibonacciService.class );
        server = GrizzlyHttpServerFactory.createHttpServer( BASE_URI,
                                                            rc );

        server.start();
        Client c = ClientBuilder.newClient();
        target = c.target( BASE_URI );
    }

    @After
    public void tearDown() throws Exception
    {
        server.shutdown();
    }

    /**
     * Tests the Fibonacci REST webservice 
     */
    @Test
    public void testFibonacci()
    {
        //TEST CASE 1 Fibonacci Series for n=5
        FibonacciData lData = null;
        lData = invokeFibonacciService( "5" );
        System.out.println( lData.getFibonacciNumbers().toString() );
        assertEquals( "[0, 1, 1, 2, 3]",
                      lData.getFibonacciNumbers().toString() );
        assertEquals( "",
                      lData.getErrorMessage() );

        //TEST CASE 1 Fibonacci Series for n=-1
        lData = invokeFibonacciService( "-1" );
        assertNotEquals( "[0, 1, 1, 2, 3]",
                         lData.getFibonacciNumbers().toString() );
        assertEquals( "The input should be numeric value in the range of 0-100",
                      lData.getErrorMessage() );
    }

    /**
     * Utility Method to Invoke Service
     * @param number
     * @return
     */
    public FibonacciData invokeFibonacciService( String number )
    {
        return target.path( "fibonacci" )
                .path( "fetch" )
                .queryParam( "number",
                             number )
                .request()
                .accept( MediaType.APPLICATION_JSON )
                .get( FibonacciData.class );

    }

}
