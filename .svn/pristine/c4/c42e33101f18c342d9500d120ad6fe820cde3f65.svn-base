package tools;

import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

/**
 * Creates the Ellipse Tool.
 * 
 * @author Connor Lundberg
 * @version 5/11/2016
 */
public class Ellipse extends AbstractTool implements Tool
{

    /**
     * 
     */
    private static final long serialVersionUID = 7039251541080979536L;

    /**
     * Creates the Ellipse.
     * 
     * @param theInitialPoint The initial point
     * @param theCurrentPoint The current point
     * @param theWidth The width
     * @param theBorderColor The border color
     * @param theFillColor The fill color
     * @param theIsFilled If it's filled or not
     */
    public Ellipse(final Point theInitialPoint, final Point theCurrentPoint,
                      final int theWidth, final Color theBorderColor, final Color theFillColor,
                      final boolean theIsFilled)
    {
        super(new Ellipse2D.Double(), theInitialPoint, theCurrentPoint, theWidth, 
              theBorderColor, theFillColor,
              theIsFilled);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void paint()
    {
        setShape(new Ellipse2D.Double());
        ((Ellipse2D) getShape()).setFrameFromDiagonal(getInitialPoint().getX(), 
                                                      getInitialPoint().getY(), 
                                                      getCurrentPoint().getX(), 
                                                      getCurrentPoint().getY());
    }

}
