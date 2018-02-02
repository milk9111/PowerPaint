/*
 * Assignment 5
 * PowerPaint
 */
package tools;

import java.awt.Color;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

/**
 * My AbstractTool class that all of my Tools will
 * inherit from.
 * 
 * @author Connor Lundberg
 * @version 5/11/2016
 */
public abstract class AbstractTool extends AbstractAction implements Tool, Cloneable
{
    
    /**
     * 
     */
    private static final long serialVersionUID = -8492489032900050295L;

    /** The Tool's shape. */
    private Shape myShape;
    
    /** The Tool's initial point. */
    private Point myInitialPoint;
    
    /** The Tool's current point. */
    private Point myCurrentPoint;
    
    /** The Tool's width. */
    private int myWidth;
    
    /** The Tool's border color. */
    private Color myBorderColor;
    
    /** The Tool's fill color. */
    private Color myFillColor;
    
    /** If the Tool is filled. */
    private boolean myIsFilled;

    /**
     * The AbstractTool's private constructor. It takes a width, border color,
     * fill color, and an isFilled boolean.
     * 
     * @param theShape The Tool's shape
     * @param theInitialPoint The Tool's initial point
     * @param theCurrentPoint The Tool's current point
     * @param theWidth The Tool's width
     * @param theBorderColor The Tool's border color
     * @param theFillColor The Tool's fill color
     * @param theIsFilled If the Tool is filled
     */
    protected AbstractTool(final Shape theShape, final Point theInitialPoint, 
                           final Point theCurrentPoint, final int theWidth, 
                           final Color theBorderColor, final Color theFillColor, 
                           final boolean theIsFilled)
    {
        super();
        myShape = theShape;
        myInitialPoint = (Point) theInitialPoint.clone();
        myCurrentPoint = (Point) theCurrentPoint.clone();
        myWidth = theWidth;
        myBorderColor = theBorderColor;
        myFillColor = theFillColor;
        myIsFilled = theIsFilled;
    }
    
    @Override
    public Tool clone() throws CloneNotSupportedException
    {
        return (Tool) super.clone();
    }

    /**
     * Sets the shape.
     * 
     * @param theShape The new shape
     */
    public void setShape(final Shape theShape)
    {
        myShape = theShape;
    }
    
    /**
     * Sets the initial point.
     * 
     * @param theStart The new start point
     */
    public void setInitialPoint(final Point theStart)
    {
        myInitialPoint = (Point) theStart.clone();
    }
    
    /**
     * Returns the border color.
     * 
     * @return The border color
     */
    public Color getBorderColor()
    {
        return myBorderColor;
    }
    
    /**
     * Returns the fill color.
     * 
     * @return The fill color
     */
    public Color getFillColor()
    {
        return myFillColor;
    }
    
    
    /**
     * Returns the fill.
     * 
     * @return The fill
     */
    public boolean isFilled()
    {
        return myIsFilled;
    }
    
    /**
     * Returns the thickness.
     * 
     * @return The thickness
     */
    public int getWidth()
    {
        return myWidth;
    }
    
    /**
     * Returns the Tool's shape.
     * 
     * @return The shape
     */
    public Shape getShape()
    {
        return myShape;
    }
    
    /**
     * Returns a clone of the initial point.
     * 
     * @return A clone of the initial point
     */
    public Point getInitialPoint()
    {
        return (Point) myInitialPoint.clone();
    }
    
    /**
     * Returns a clone of the current point.
     * 
     * @return A clone of the current point
     */
    public Point getCurrentPoint()
    {
        return (Point) myCurrentPoint.clone();
    }
    
    /**
     * Unused paint method that is overridden by all concrete tools.
     */
    public abstract void paint();
    
    /**
     * Sets the current point.
     * 
     * @param thePoint The new current point
     */
    //change to setCurrentPoint that takes a point
    public void setCurrentPoint(final Point thePoint)
    {
        myCurrentPoint = thePoint;
    }
    
    /**
     * Sets the width (brush thickness).
     * 
     * @param theWidth The new width
     */
    public void setWidth(final int theWidth)
    {
        myWidth = theWidth;
    }
    
    /**
     * Sets the draw color.
     * 
     * @param theColor The new draw color
     */
    public void setDrawColor(final Color theColor)
    {
        myBorderColor = theColor;
    }
    
    /**
     * Sets the fill color.
     * 
     * @param theColor The new fill color
     */
    public void setFillColor(final Color theColor)
    {
        myFillColor = theColor;
    }
    
    /**
     * Sets if the shape is filled or not.
     * 
     * @param theValue The new value
     */
    public void setIsFilled(final boolean theValue)
    {
        myIsFilled = theValue;
    }
    
    @Override
    public void actionPerformed(final ActionEvent theEvent)
    {
        putValue(SELECTED_KEY, true);
        putValue(SHORT_DESCRIPTION, getClass().getSimpleName());
    }
    
}
