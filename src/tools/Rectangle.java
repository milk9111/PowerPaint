package tools;

import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Rectangle2D;


/**
 * Creates the Rectangle Tool.
 * 
 * @author Connor Lundberg
 * @version 5/11/2016
 */
public class Rectangle extends AbstractTool implements Tool
{

    /**
     * 
     */
    private static final long serialVersionUID = -44145085462412326L;

    /**
     * Creates the Rectangle. 
     * 
     * @param theInitialPoint The initial point
     * @param theCurrentPoint The current point
     * @param theWidth The width
     * @param theBorderColor The border color
     * @param theFillColor The fill color
     * @param theIsFilled If it's filled or not
     */
    public Rectangle(final Point theInitialPoint, final Point theCurrentPoint,
                     final int theWidth, final Color theBorderColor, final Color theFillColor,
                     final boolean theIsFilled)
    {
        super(new Rectangle2D.Double(), theInitialPoint, theCurrentPoint, theWidth, 
              theBorderColor, theFillColor, theIsFilled);
    }

    @Override
    public void paint()
    {
        setShape(new Rectangle2D.Double());
        ((Rectangle2D) getShape()).setFrameFromDiagonal(getInitialPoint().getX(), 
                                                        getInitialPoint().getY(), 
                                                        getCurrentPoint().getX(), 
                                                        getCurrentPoint().getY());
    }

}
