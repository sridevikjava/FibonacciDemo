package com.demo.fibonacci;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * POJO for JSON Data
 */
public class FibonacciData
{
    private List<Integer> fibonacciNumbers = new ArrayList<Integer>();
    private String errorMessage = "";

    public FibonacciData()
    {

    }

    public String getErrorMessage()
    {
        return errorMessage;
    }

    public void setErrorMessage( String errorMessage )
    {
        this.errorMessage = errorMessage;
    }

    public List<Integer> getFibonacciNumbers()
    {
        return fibonacciNumbers;
    }

    public void setFibonacciNumbers( List<Integer> fibonacciNumbers )
    {
        this.fibonacciNumbers = fibonacciNumbers;
    }

    @Override
    public String toString()
    {
        StringBuilder lStrBuilder = new StringBuilder();

        if( fibonacciNumbers != null && fibonacciNumbers.size() > 0 )
        {
            for( Iterator<Integer> iterator = fibonacciNumbers.iterator(); iterator.hasNext(); )
            {
                Integer value = iterator.next();
                lStrBuilder.append( value );
                lStrBuilder.append( " " );
            }
        }
        return lStrBuilder.toString();
    }

}
