package org.recursion.example;

import org.recursion.example.tree.TreeNode;

public class Main
{
    public TreeNode tree;

    public Main( String[] args )
    {
        tree = new TreeNode(); //1
        tree.addChild( new TreeNode() ); //2
    }

    public static void main( String[] args )
    {
        //initial state
        Main app = new Main( args );
        System.out.print( "\nInitial state" );
        app.tree.print( 0 );

        System.out.print( "\nCopying 1" );
        app.tree.addChild( app.copy( 1 ) );
        TreeNode n = app.tree.getChild( 1 );
        n.setName( n.getName() + "-copied" );
        n = n.getChild( 0 );
        n.setName( n.getName() + "-copied" );
        app.tree.print( 0 );

        System.out.print( "\nCopying 2" );
        app.tree.addChild( app.copy( 1 ) );
        app.tree.print( 0 );
    }

    private static TreeNode findNode( TreeNode node, int id )
    {
        if ( node.getId() == id )
        {
            return node;
        }
        if ( node.isLeaf() )
        {
            return null; //no such nodes in this branch
        }
        //else search in depth
        for ( int i = 0; i < node.getChildrenCount(); i++ )
        {
            TreeNode child = node.getChild( i );
            TreeNode node1 = findNode( child, id );
            if ( node1 != null )
            {
                return node1;
            }
        }

        return null;  //no such nodes in the subTree
    }

    public TreeNode copy( int nodeId )
    {
        TreeNode oldNode = findNode( tree, nodeId );
        if ( oldNode == null )
        {
            return null;
        }

        return copy( oldNode );
    }

    private TreeNode copy( TreeNode node )
    {
        TreeNode newNode = new TreeNode( node.getName() );

        for ( int i = 0; i < node.getChildrenCount(); i++ )
        {
            newNode.addChild( copy( node.getChild( i ) ) );
        }

        return newNode;
    }
}