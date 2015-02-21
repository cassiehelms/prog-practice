import java.util.Scanner;
import java.io.File;

public class Example
{
    

    // Write a function to reverse a string
    public static String reverse( String origString )
    {
        String newString = "";
        for (int i = origString.length() - 1; i >= 0; i-- )
        {
            // Step through the original string from end to beginning
            newString += origString.charAt( i );
            // Concatenate each character to a new string
        }
        // return the new string
        return newString;
    }

    // Write a smarter function to reverse a string
    public static String reverseWithCharArray( String origString )
    {
        // Change to character array
        char[] origChars = origString.toCharArray();
        int length = origString.length();
        int last = length - 1;
        // step through character array until you're in the middle,
        for (int i = 0; i < length/2; i++ )
        {
            // swapping the first and last elements
            char holding = origChars[i];
            origChars[i] = origChars[last - i];
            origChars[last - i] = holding;
        }
        // Return a new string made from the character array
        return new String(origChars);
    }

    // Write a function to compute Nth fibonacci number
    public static long fibonacci( int n )
    {
        if ( n <= 1 )
        {
            return 1;
        }
        else
        {
            return fibonacci( n - 2 ) + fibonacci( n - 1 );
        }
    }
    
    // Print the grade school multiplication table 
    public static void printMultTable( int n )
    {
        // 1 2 3 4 
        // 2 4 6 8
        // 3 6 9 12
        // 4 8 12 16
        
        // outside loop traverses print lines
        for (int i = 1; i <= n; i++ )
        {
            // now we print each row
            for ( int j = 1; j <= n; j++ )
            {
                System.out.print( String.format( "%4d", j*i) );    
            }
            System.out.println();
        }
    }

    // Write a function that sums up integers from a text file, one int per line.
    public static int sumFromFile( String filename )
    {
        int sum = 0;
        try
        {
            Scanner fileScanner = new Scanner( new File( filename ) );
            while ( fileScanner.hasNextInt() )
            {
                int nextInt = fileScanner.nextInt();
                System.out.println( nextInt );
                sum += nextInt;
            }
        }
        catch( Exception ex )
        {
            ex.printStackTrace();
        } 
        return sum;
    }

    public static void printOddNumbers( int n )
    {
        for ( int i = 1; i <= n; i += 2 )
        {
            System.out.print( String.format( "%4d", i ) );
        }
        System.out.println();
    }

    public static int findLargestInt( int[] input )
    {
        int largest = 0;
        if ( input == null || input.length == 0 )
        {
            return largest;
        }
        for ( int i = 0; i < input.length; i++ ) 
        {
            if ( input[i] > largest )
            {
                largest = input[i];
            }
        }
        return largest;
    }
    

    // Format an RGB value (three 1-byte numbers) as a 6-digit hexadecimal string.
    public static String rgbToHex( int r, int g, int b )
    {
        return ( toHex(r) + toHex(g) + toHex(b) );
    }  
    
    public static String toHex( int a )
    {
        String hexStr = Integer.toHexString( a );
        if ( hexStr.length() == 1 )
        {
            hexStr = 0 + hexStr;
        }
        hexStr = hexStr.toUpperCase();
        return hexStr;
    }  
    
    public static int atoi( String a )
    {
        int returnInt = 0;
        Scanner atoiScan = new Scanner( a );
        if ( atoiScan.hasNextInt() )
            returnInt = atoiScan.nextInt();

        return returnInt; 
    }

    public static void main(String[] args)
    {
        System.out.println( reverse( "cats" ) );
        System.out.println( reverse( "coast" ) );
        System.out.println( reverseWithCharArray( "cats" ) );
        System.out.println( reverseWithCharArray( "coast" ) );
        System.out.println( fibonacci( 4 ) );
        System.out.println( fibonacci( 3 ) );

        for ( int i = 0; i < 10; i++ ) {
            System.out.print ( fibonacci(i) + ", " );
        }
        System.out.println ( fibonacci(10) );
        System.out.println();
        System.out.println();
        System.out.println();
        printMultTable( 12 );
        String fileName = "numbers.txt";
        System.out.println( "sum of numbers from " + fileName + " is " + sumFromFile( fileName ) );
        printOddNumbers( 99 );
        System.out.println( "largest int: " + findLargestInt( new int[] { 100, 200, 300, 400, 500, 600, 700, 800 } ) );
        
        System.out.println( Integer.toBinaryString( 88 ) );
        System.out.println( rgbToHex( 255, 0, 128 ) );        
        System.out.println( atoi( "6678" ) );
        System.out.println( atoi( "-5002" ) );
        System.out.println( atoi( "-5002" ) + atoi( "6678" ) );
        
    }
}
