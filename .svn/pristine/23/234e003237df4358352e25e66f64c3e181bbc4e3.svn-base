package tools;

import java.awt.Color;
import java.awt.Point;
import java.awt.Shape;

import javax.swing.Action;


/**
 * The interface all Tools will implement. Extends 
 * MouseMotionListener.
 * @author Connor Lundberg
 * @version 5/11/2016
 */
public interface Tool extends Cloneable, Action
{
    /**
     * Paints the Tool.
     */
    void paint();
    
    /**
     * On mouse dragged.
     * 
     * @param thePoint The new current point

     */
    void setCurrentPoint(final Point thePoint);
    
    /**
     * Makes a clone.
     * 
     * @return The new clone 
     * @throws CloneNotSupportedException Clone isn't supported
     */
    Tool clone() throws CloneNotSupportedException;
    
    /**
     * Sets the isFilled value.
     * 
     * @param theValue The new value
     */
    void setIsFilled(final boolean theValue);
 
    /**
     * Sets the draw color value.
     * 
     * @param theColor The new color
     */
    void setDrawColor(final Color theColor);
    
    /**
     * Sets the fill color value.
     * 
     * @param theColor The new color
     */
    void setFillColor(final Color theColor);
    
    /**
     * Sets the initial point value.
     * 
     * @param theStart The new point
     */
    void setInitialPoint(final Point theStart);
    
    /**
     * Sets the new shape.
     * 
     * @param theShape The new shape
     */
    void setShape(final Shape theShape);
    
    
    
    /** 
     * Returns the Shape. 
     * 
     * @return The shape
     * */
    Shape getShape();
    
    /**
     * Returns the draw color.
     * 
     * @return The draw color
     */
    Color getBorderColor();
    
    /**
     * Returns the fill color.
     * 
     * @return The fill color
     */
    Color getFillColor();
    
    
    /**
     * Returns the fill.
     * 
     * @return The fill
     */
    boolean isFilled();
    
    /**
     * Returns the stroke thickness.
     * 
     * @return The thickness
     */
    int getWidth();
    
    /**
     * Returns a clone of the initial point.
     * 
     * @return A clone of the initial point
     */
    Point getInitialPoint();
    
    /**
     * Returns a clone of the current point.
     * 
     * @return A clone of the current point
     */
    Point getCurrentPoint();

    /**
     * Sets the width.
     * 
     * @param theThickness The new width
     */
    void setWidth(int theThickness);
    
    
}
