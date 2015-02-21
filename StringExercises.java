import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class StringExercises
{
    
    private static Character firstNonalphebeticLetter( String searchStr )
    {
        String oldSearchStr = searchStr; // save a copy
        // make everything small so we can do char comparisons accurately
        searchStr = searchStr.toLowerCase(); 
        // initialize the previous letter to the first letter in string
        char prevLetter = searchStr.charAt(0); 
        for ( int charIndex = 1; charIndex < searchStr.length(); charIndex++ )
        {
            char currLetter = searchStr.charAt( charIndex );
            if ( currLetter < prevLetter )
            {
                return oldSearchStr.charAt( charIndex );
            }
            prevLetter = currLetter; 
        }
        return null;
    }
    
    private static ArrayList<String> parseLine( String line )
    {
        ArrayList<String> parsedList = new ArrayList<String>();
        Scanner lineScanner = new Scanner( line );
        while ( lineScanner.hasNext() )
        {
            parsedList.add( lineScanner.next() );
        } 
        return parsedList;
    }
    
    public static void printStats( ArrayList<String> statList )
    {
        System.out.print( "ArrayList contents: " );
        for ( int listIndex = 0; listIndex < statList.size(); listIndex++ )
        {
            System.out.print( statList.get( listIndex ) + " ");
        }
        System.out.println();
        System.out.println( "ArrayList size: " + statList.size() );
    }

    private static void scanInputsIndefinitely()
    {
        Scanner inScanner = new Scanner( System.in );
        String next = null;        
                
        System.out.println( "I will now print out everything you say until you say 'done'" );
        next = inScanner.nextLine();
        while ( next.compareToIgnoreCase( "done" ) != 0 )
        {
            System.out.println( "Regurgitating your word: " + next );
            next = inScanner.nextLine();
        }
        System.out.println( "Regurgitating finished" );
    }
    
    private static String pullEventValue( String eventString )
    {
        String returnStr = null;
        if ( !eventString.contains( "event=" ) )
        {
            return returnStr;
        }
        Scanner eventScan = new Scanner( eventString );
        while ( eventScan.hasNext() )
        {
            String next = eventScan.next();
            if ( next.startsWith( "event=" ) && next.length() > "event=".length() )
            {
                returnStr = next.substring( "event=".length() );
                break;
            }  
        }
        return returnStr;
    }

    private static void scanAndPrintFile( String fileName ) throws FileNotFoundException
    {
        if ( fileName == null )
        {
            return;
        }

        File fileToScan = new File( fileName );
        Scanner fileScanner = new Scanner( fileToScan );
        while ( fileScanner.hasNextLine() )
        {
            System.out.println( fileScanner.nextLine() );
        }
    }

    private static void printDiamond( int max )
    {
        if ( max <= 0 )
        {
            return;
        }
        if ( max % 2 == 0 )
        {
            max++;
        }
        printDiamondRecursively( 1, max );
    }
    
    private static void printLineOfDiamond( int spaceBuffer, int amount )
    {
        for ( int i = 0; i < spaceBuffer; i++ )
        {
            System.out.print(" ");
        }
        for ( int i = 0; i < amount; i++ )
        {
            System.out.print("*");
        }
        System.out.println();
    }
    
    private static void printDiamondRecursively( int amount, int max )
    {
        int spaceBuffer = (max - amount)/2;
        printLineOfDiamond( spaceBuffer, amount );
        if ( amount < max )
        {
            printDiamondRecursively( amount + 2, max );
            printLineOfDiamond( spaceBuffer, amount );
        }
    }


    public static void main( String[] args )
    {
        String testStrings[] = { "cats", "abcdef", "RainbowSherbert", "NemoIsCool", "HONEYCOMB", "BEEHIVE" };
        for ( int testIndex = 0; testIndex < testStrings.length; testIndex++ )
        {
            System.out.println( "The first non-alphebetic letter in " + 
                testStrings[testIndex] + " is: " + 
                firstNonalphebeticLetter( testStrings[testIndex] ) );
        }
        //scanInputsIndefinitely(); 
        ArrayList<String> lightAsFeather = parseLine( "Light as a feather, stiff as a board." );
        printStats( lightAsFeather );
        ArrayList<String> northGuardians = parseLine( "Guardians of the watchtowers of the North, by the powers of mother and earth... hear us." );
        printStats( northGuardians );
        System.out.println( "abcdef.compareTo(abcdefg): " + "abcdef".compareTo( "abcdefg" ) );
        System.out.println( "cats.compareTo(cats): " + "cats".compareTo( "cats" ) );
        System.out.println( "catsdogs.equals(cats): " + "catsdogs".equals( "cats" ) );
        System.out.println( "cats.equals(cats): " + "cats".equals( "cats" ) );
        System.out.println( "cats and dogs.contains(cats): " + "cats and dogs".contains( "cats" ) );
        System.out.println( "cats and dogs.contains(nuts): " + "cats and dogs".contains( "nuts" ) );
        System.out.println( "123456789.substring(5): " + "123456789".substring(5) );
        System.out.println( "123456789.substring(2, 5): " + "123456789".substring(2, 5) );
        System.out.println( "123456789.length(): " + "123456789".length() );
        System.out.println( "pullEventValue( cats dogs=8 event=7 mermaids): " + pullEventValue( "cats dogs=8 event=7 mermaids" ) );
        System.out.println( "pullEventValue( cats dogs=8 devent=7 mermaids): " + pullEventValue( "cats dogs=8 devent=7 mermaids" ) );
        System.out.println( "pullEventValue( cats dogs=8 mermaids): " + pullEventValue( "cats dogs=8 mermaids" ) );
        
        if ( args.length > 0 )
        { 
            try
            {        
                scanAndPrintFile( args[0] );
            }
            catch ( FileNotFoundException fileEx )
            {
                System.out.println( "Sorry, " + args[0] + " is not a valid file." );
            }
            catch ( Exception ex )
            {
                System.out.println( "Exception caught: " + ex );
            }
        }
        printDiamond( 8 );
    }
}
