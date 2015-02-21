
public class TelephoneWords
{

    public static char getCharKey( int telephoneKey, int place )
    {
        place = place - 1;
        char foundChar = '*';
        char[][] telephoneLetters = { { '0', '0', '0' },
                                      { '1', '1', '1' }, 
                                      { 'A', 'B', 'C' }, 
                                      { 'D', 'E', 'F' },
                                      { 'G', 'H', 'I' },
                                      { 'J', 'K', 'L' },
                                      { 'M', 'N', 'O' },
                                      { 'P', 'R', 'S' },
                                      { 'T', 'U', 'V' },
                                      { 'W', 'X', 'Y' } 
                                    };
        if ( telephoneKey >= 0 && telephoneKey <= 9 && place >= 0 && place <= 2 )
        {
            foundChar = telephoneLetters[telephoneKey][place];
        }
        return foundChar; 
    }

    public static void testGetCharKey()
    {
        System.out.println( "getCharKey( 0, 2 ) should be 0:: " + getCharKey( 0, 2 ) );
        System.out.println( "getCharKey( 2, 1 ) should be A: " + getCharKey( 2, 1 ) );
        System.out.println( "getCharKey( 3, 2 ) should be E: " + getCharKey( 3, 2 ) );
        System.out.println( "getCharKey( 9, 3 ) should be Y: " + getCharKey( 9, 3 ) );
        System.out.println( "getCharKey( 9, 3 ) should be Y: " + getCharKey( 9, 3 ) );
        System.out.println( "getCharKey( 0, 0 ) should be *: " + getCharKey( 0, 0 ) );
        System.out.println( "getCharKey( -1, 1 ) should be *: " + getCharKey( -1, 1 ) );
        System.out.println( "getCharKey( 9, 4 ) should be *: " + getCharKey( 9, 4 ) );
        System.out.println( "getCharKey( 10, 3 ) should be *: " + getCharKey( 10, 3 ) );
    }
    
    public static void printAllTelephoneWords( int[] phoneNumber )
    {
        char[] printThis = new char[7];
        if ( phoneNumber.length > 7 )
        {
            System.out.println( "printAllTelephonWords: number was larger than seven numbers" );
            return;
        }
        for ( int i_0 = 1; i_0 <= 3; i_0++ )
        {
            printThis[0] = getCharKey( phoneNumber[0], i_0 );
            for ( int i_1 = 1; i_1 <= 3; i_1++ )
            {
                printThis[1] = getCharKey( phoneNumber[1], i_1 );
                for ( int i_2 = 1; i_2 <= 3; i_2++ )
                {
                    printThis[2] = getCharKey( phoneNumber[2], i_2 );
                    for ( int i_3 = 1; i_3 <= 3; i_3++ )
                    {
                        printThis[3] = getCharKey( phoneNumber[3], i_3 );
                        for ( int i_4 = 1; i_4 <= 3; i_4++ )
                        {
                            printThis[4] = getCharKey( phoneNumber[4], i_4 );
                            for ( int i_5 = 1; i_5 <= 3; i_5++ )
                            {
                                printThis[5] = getCharKey( phoneNumber[5], i_5 );
                                for ( int i_6 = 1; i_6 <= 3; i_6++ )
                                {
                                    printThis[6] = getCharKey( phoneNumber[6], i_6 );
                                    System.out.println( printThis );
                                }
                            }

                        }

                    }
                }
            }
        }
    }
    
    public static void main( String[] args )
    {
        printAllTelephoneWords( new int[] { 8, 6, 6, 2, 6, 6, 5 } ); 
    }
}
