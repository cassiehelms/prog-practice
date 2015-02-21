// An almost templated Java doubly-linked list

public class Node<T> {
    
    private Node<T> next = null;
    private Node<T> prev = null;
    private T data = null;
     
    public Node( T data_ )
    {
        data = data_;
    }

    public void setNext( Node<T> nextNode )
    {
        next = nextNode;
        if ( next != null && next.getPrevious( ) != this )
        { 
            nextNode.setPrevious( this );
        }
    } 

    public void setPrevious( Node<T> prevNode )
    {
        prev = prevNode;
        if ( prev != null && prev.getNext( ) != this )
        {
            prev.setNext( this );
        }
    }
    
    public Node<T> getNext( )
    {
        return next;
    }
    
    public Node<T> getPrevious( )
    {
        return prev;
    }

    public String toString( )
    {
        return data.toString();
    }

    public T getData( )
    {
        return data;
    }   

    public static <T> Node<T> findNode( Node<T> headNode, T data_ )
    {
        for ( Node<T> iterNode = headNode; iterNode != null; iterNode = iterNode.getNext() )
        {
            if ( iterNode.getData().equals( data_ ) )
            {
                return iterNode;
            }
        } 
        return null;
    }
    
    public static <T> void printList( Node<T> headNode )
    {
        for ( Node<T> itNode = headNode; itNode != null; itNode = itNode.getNext() )
        {
            System.out.print( itNode + " " );
        }
        System.out.println( );
    }

    public static <T> int listSize( Node<T> headNode )
    {
        int size = 0;
        if ( headNode != null )
        {
            for ( Node<T> pointerNode = headNode; pointerNode != null; pointerNode = pointerNode.getNext() )
            {
                size++;
            }
        } 
        return size;

    }

    public static void main( String[] args )
    {
        Node<String> node1 = new Node<String>( "cats" );
        Node<String> node2 = new Node<String>( "dogs" );
        node1.setNext( node2 );
        System.out.println( "Printing a two element list:" );
        printList( node1 );
        System.out.println( "Printing a one element list:" );
        node1.setNext( null );
        printList( node1 );
        
        Node<String> stringList = new Node<String>( "String0" );
        Node<String> pointerNode = stringList;
        for ( int index = 1; index < 100; index++ )
        {
            Node<String> newNode = new Node<String>( "String" + index );
            pointerNode.setNext( newNode );
            pointerNode = newNode;
        }
        printList( stringList ); 
        Node<String> node57 = findNode( stringList, "String57" );
        System.out.println( "Found node 57: " + node57 );

        Node<Integer> intList = new Node<Integer>( 0 );
        Node<Integer> intPointer = intList;
        for ( int index = 1; index < 1000; index++ )
        {
            Node<Integer> newNode = new Node<Integer>( index );
            intPointer.setNext( newNode );
            intPointer = newNode;
        }
        printList( intList );
        System.out.println( findNode( intList, 747 ) );
        System.out.println( findNode( intList, 767 ) );
        System.out.println( findNode( intList, 200 ) );
        System.out.println( findNode( intList, 319 ) );
        System.out.println( "Size of intList: " + listSize( intList ) );
        System.out.println( "Size of stringList: " + listSize( stringList ) );
    }

}
