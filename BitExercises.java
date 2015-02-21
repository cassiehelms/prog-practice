// http://stackoverflow.com/questions/141525/absolute-beginners-guide-to-bit-shifting
// http://docs.oracle.com/javase/tutorial/java/nutsandbolts/op3.html
// http://www.tutorialspoint.com/java/java_bitwise_operators_examples.htm

public class BitExercises
{
    
    
    public static void doSmallExercises()
    {
        int a = 60;     /* 0011 1100 */
        int b = 13;     /* 0000 1101 */
        int c = 0;

        /* do bitwise AND operation */
        c = a & b;      /* 0000 1100, 12 */
        System.out.println( a + " & " + b + " = " + c );
        
        /* do bitwise OR operation */
        c = a | b;      /* 0011 1101, 61 */
        System.out.println( a + " | " + b + " = " + c );

        /* do bitwise XOR operation */
        c = a ^ b;      /* 0011 0001, 49 */
        System.out.println( a + " ^ " + b + " = " + c );
        
        /* invert a bit pattern */
        c = ~a;         /* 1100 0011 */ 
                        /* the MSB is 1, so this is a negative number */
                        /* Do two's complement to find out what number */
                        /* Invert the bits and add one */
                        /* 0011 1100 */
                        /* 0011 1101 = 61, so we're talking about -61 */

                        /* alternative to twos complemenet */
                        /* start at LSB, don't change the digits until you hit the first one. */
                        /* then, keep that first one, but flip the rest of the bits up to MSB */
                        /* 1100 0011 -> 1 -> 0011 1101 = 61 */
        System.out.println( "~" + a + " = " + c );
        
        /* Shift to the left two places */
        /* 0011 1100 -> 1111 0000, 240 */     
        c = a << 2;     /* 240 = 1111 0000 */
        System.out.println("a << 2 = " + c );
        
        /* Logical right shift two places */
        c = a >>> 2;     /* 215 = 0000 1111 */
        System.out.println("a >>> 2 = " + c );

        /* Arithmetic right shift two places; preserves the original MSB */
        /* 0011 1100 -> 0000 1111, 15 */
        c = a >> 2;     
        System.out.println("a >> 2  = " + c );


        /* v---- TODO, did your math wrong on this one */
        a = -61; /* 1100 0011 -> 1011 0000, 0101 0000, -80 */
        c = a >> 2;
        System.out.println("a >> 2  = " + c );

    }

    public static Boolean isMSBSet( int testMe )
    {
        if ( testMe > 255 )
        {
            return false;
        }
        /* byte with MSB set = 1000 0000 = 128 */
        int tested = 128 & testMe;
        System.out.println( "testMe: " + testMe + " tested: " + tested );
        if ( tested == 128 ) 
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }

    public static int countBits( int value )
    {
        int bits = 0;
        while ( value > 1 ) 
        {
            bits++;
            value = value/2;
        }
        bits++;
        return bits;
    }

    public static Boolean isBinaryPalindrome( int value )
    {
        String binaryStr = Integer.toBinaryString( value ); 
        int length = binaryStr.length();
        int last = length - 1;
        for ( int i = 0; i < length/2; i++ )
        {
            if ( binaryStr.charAt(i) != binaryStr.charAt(last-i) )
            {
                return false;
            }
        }
        return true;
    }

    public static void main( String[] args )
    {
        doSmallExercises();
        System.out.println( isMSBSet( 64 ) );
        System.out.println( isMSBSet( 132 ) );
        System.out.println( isMSBSet( 254 ) );
        System.out.println( isMSBSet( 127 ) );
        System.out.println( "countBits 128: " + countBits( 128 ) + " (" + Integer.toBinaryString( 128 ) + ")" );
        System.out.println( "countBits 5: " + countBits( 5 ) + " (" + Integer.toBinaryString( 5 ) + ")");
        System.out.println( "countBits 68: " + countBits( 68 ) + " (" + Integer.toBinaryString( 68 ) + ")");
        System.out.println( "countBits 1: " + countBits( 1 ) + " (" + Integer.toBinaryString( 1 ) + ")");
        System.out.println( "countBits 3: " + countBits( 3 ) + " (" + Integer.toBinaryString( 3 ) + ")");
        System.out.println( "isBinaryPalindrome 128: " + isBinaryPalindrome( 128 ) + " (" + Integer.toBinaryString( 128 ) + ")" );
        System.out.println( "isBinaryPalindrome 129: " + isBinaryPalindrome( 129 ) + " (" + Integer.toBinaryString( 129 ) + ")" );
        System.out.println( "isBinaryPalindrome 3: " + isBinaryPalindrome( 3 ) + " (" + Integer.toBinaryString( 3 ) + ")" );
        System.out.println( "isBinaryPalindrome 5: " + isBinaryPalindrome( 5 ) + " (" + Integer.toBinaryString( 5 ) + ")" );
        System.out.println( "isBinaryPalindrome 33: " + isBinaryPalindrome( 33 ) + " (" + Integer.toBinaryString( 33 ) + ")" );
        System.out.println( "isBinaryPalindrome 32: " + isBinaryPalindrome( 32 ) + " (" + Integer.toBinaryString( 32 ) + ")" );
        System.out.println( "isBinaryPalindrome 51: " + isBinaryPalindrome( 51 ) + " (" + Integer.toBinaryString( 51 ) + ")" );
    }
}
