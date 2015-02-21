public class BinarySearchTree<T>
{
    private T m_data = null;
    private BinarySearchTree<T> m_rightChild = null;
    private BinarySearchTree<T> m_leftChild = null;

    public BinarySearchTree( T data )
    {
        m_data = data;
    }

    public BinarySearchTree( T data, BinarySearchTree<T> rC, BinarySearchTree<T> lC )
    {
        m_data = data;
        m_rightChild = rC;
        m_leftChild = lC;
    }
    
    public BinarySearchTree<T> getLeft()
    {
        return m_leftChild;
    } 
    
    public BinarySearchTree<T> getRight()
    {
        return m_rightChild; 
    }
    
    public T getData()
    {
        return m_data;
    }
    
    public String toString()
    {
        return m_data.toString();
    }

    public static <T> void printTreeInOrder( BinarySearchTree<T> node )
    {
        if ( node == null )
        {
            return;
        }
        if ( node.getLeft() != null )
        {
            printTreeInOrder( node.getLeft() );
        }  
        System.out.print( node.getData() + " " );
        if ( node.getRight() != null )
        {
            printTreeInOrder( node.getRight() );
        }
    }
    
    public static <T> void printTreePreOrder( BinarySearchTree<T> node )
    {
        if ( node == null )
        {
            return;
        }
        System.out.print( node.getData() + " " );
        if ( node.getLeft() != null )
        {
            printTreePreOrder( node.getLeft() );
        }
        if ( node.getRight() != null )
        {
            printTreePreOrder( node.getRight() );
        }
    }
        
    public static <T> void printTreePostOrder( BinarySearchTree<T> node )
    {
        if ( node == null )
        {
            return;
        }
        if ( node.getLeft() != null )
        {
            printTreePostOrder( node.getLeft() );
        }
        if ( node.getRight() != null )
        {
            printTreePostOrder( node.getRight() );
        }
        System.out.print( node.getData() + " " );
    }

    public static <T> int treeHeight( BinarySearchTree<T> node )
    {
        if ( node == null )
        {
            return 0;
        }
        return 1 + Math.max( treeHeight( node.getLeft() ), treeHeight ( node.getRight() ) );
    }

    public static BinarySearchTree<Integer> lowestCommonAncestor( BinarySearchTree<Integer> root, int value1, int value2 )
    {
        while ( root != null )
        {
            int value = root.getData();
            if ( value > value1 && value > value2 )
            {
                root = root.getLeft();
            }
            else if ( value < value1 && value < value2 )
            {
                root = root.getRight();
            }
            else
            {
                return root;
            }
        }
        return null;
    } 


    public static void main( String[] args )
    {
        BinarySearchTree<String> fT = new BinarySearchTree<String>( "F" );
        BinarySearchTree<String> gT = new BinarySearchTree<String>( "G" );
        BinarySearchTree<String> hT = new BinarySearchTree<String>( "H" );
        BinarySearchTree<String> dT = new BinarySearchTree<String>( "D", gT, fT );
        BinarySearchTree<String> eT = new BinarySearchTree<String>( "E", hT, null );
        BinarySearchTree<String> cT = new BinarySearchTree<String>( "C", eT, dT );
        BinarySearchTree<String> bT = new BinarySearchTree<String>( "B" );
        BinarySearchTree<String> aT = new BinarySearchTree<String>( "A", cT, bT );

        System.out.println( "In order tree: " );
        printTreeInOrder( aT );
        System.out.println();
        System.out.println( "Pre order tree: " );
        printTreePreOrder( aT );
        System.out.println();
        System.out.println( "Post order tree: " );
        printTreePostOrder( aT );
        System.out.println();
        System.out.println();
        System.out.println( "height of aT is: " + treeHeight( aT ) );
        
        BinarySearchTree<Integer> t10 = new BinarySearchTree<Integer>( 10 );
        BinarySearchTree<Integer> t14 = new BinarySearchTree<Integer>( 14 );
        BinarySearchTree<Integer> t4 = new BinarySearchTree<Integer>( 4 );
        BinarySearchTree<Integer> t22 = new BinarySearchTree<Integer>( 22 );
        BinarySearchTree<Integer> t12 = new BinarySearchTree<Integer>( 12, t14, t10 );
        BinarySearchTree<Integer> t8 = new BinarySearchTree<Integer>( 8, t12, t4 );
        BinarySearchTree<Integer> t20 = new BinarySearchTree<Integer>( 20, t22, t8 );

        System.out.println( "In order tree: " );
        printTreeInOrder( t20 );
        System.out.println();
        System.out.println( "Pre order tree: " );
        printTreePreOrder( t20 );
        System.out.println();
        System.out.println( "Post order tree: " );
        printTreePostOrder( t20 );
        System.out.println();
        System.out.println( "Lowest common ancestor of 4, 14: " + lowestCommonAncestor( t20, 4, 14 ) );
    }
}
