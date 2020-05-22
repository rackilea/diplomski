package org.recursion.example.tree;

import java.util.ArrayList;
import java.util.List;

public class TreeNode
{
    private static int count;

    private int id;
    private String name;
    private List<TreeNode> children = new ArrayList<TreeNode>();

    public TreeNode( String name )
    {
        id = newId();
        setName( name );
    }

    private static int newId()
    {
        return ++count;
    }

    public TreeNode()
    {
        id = newId();
        setName( id );
    }

    public int getChildrenCount()
    {
        return children.size();
    }

    public TreeNode getChild( int i )
    {
        return children.get( i );
    }

    public void addChild( TreeNode child )
    {
        children.add( child );
    }

    public boolean isLeaf()
    {
        return children.isEmpty();
    }

    public int getId()
    {
        return id;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName( int id )
    {
        setName( String.valueOf( id ) );
    }

    public void print( int ident )
    {
        System.out.println();
        System.out.print( fill( ident ) );
        System.out.print( name );

        ident += 4;
        for ( int i = 0; i < getChildrenCount(); i++ )
        {
            TreeNode child = getChild( i );
            child.print( ident );
        }
    }

    private String fill( int i )
    {
        StringBuilder sb = new StringBuilder();
        for ( int j = 0; j < i; j++ )
        {
            sb.append( ' ' );
        }

        return sb.toString();
    }
}