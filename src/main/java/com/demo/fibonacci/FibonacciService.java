package com.demo.fibonacci;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 * Root resource (exposed at "fibonacci" path)
 */
@Path( "fibonacci" )
public class FibonacciService
{
    static final Logger logger = Logger.getLogger( FibonacciService.class );
    public static final String NUMERIC_VAUE_MESSG = "The input should be numeric value in the range of 0-100";

    //TODO Need to move AppInitializer class
    static
    {
        BasicConfigurator.configure();
        logger.debug( "Initialized Log4j" );
    }

    /**
     * Reads the Input Value and finds the fibonacci series 
     * @param number
     * @return JSON Data
     */
    @GET
    @Path( "/fetch/" )
    @Produces( MediaType.APPLICATION_JSON )
    public FibonacciData showFibonacciSeries( @QueryParam( "number" ) String number )
    {
        logger.debug( "Start of findFibonacciSeries method" );
        logger.debug( "User entered value ::" + number );
        FibonacciData lData = new FibonacciData();
        try
        {
            int num = Integer.parseInt( number );

            if( num < 0 || num > 100 )
            {
                lData.setErrorMessage( NUMERIC_VAUE_MESSG );
                logger.error( "Input not in the allowed range" );
            }
            else
            {
                List<Integer> numbers = findFibonacciSeries( num );
                logger.debug( "Fibonacci Series is :" + numbers );
                lData.setFibonacciNumbers( numbers );
            }
        }
        catch( NumberFormatException nExcp )
        {
            lData.setErrorMessage( NUMERIC_VAUE_MESSG );
            logger.error( "Non Numeric value provided as Input" );
        }
        catch( Exception excp )
        {
            logger.error( "Exception Unknown" + excp.getMessage() );
        }

        logger.debug( "End of findFibonacciSeries method" );
        return lData;
    }

    /**
     * This method returns the fibonacci series for the specified number
     * @param n
     * @return
     */
    public List<Integer> findFibonacciSeries( int number )
    {
        logger.debug( "Start of findFibonacciSeries method" );
        Integer[] tempArray = new Integer[number];
        tempArray[0] = 0;
        tempArray[1] = 1;

        int i;
        for( i = 2; i < tempArray.length; i++ )
        {
            tempArray[i] = tempArray[i - 2] + tempArray[i - 1];
        }

        return Arrays.asList( tempArray );
    }

}
