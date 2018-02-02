
package tools;

import java.awt.Color;
import java.awt.Point;

import java.awt.geom.Line2D;


/**
 * My Line class that creates and handles the Line drawing Tool.
 * 
 * @author Connor Lundberg
 * @version 5/11/2016
 */
public class Line extends AbstractTool implements Tool
{


    /**
     * Auto-generated ID.
     */
    private static final long serialVersionUID = -8029133638848436372L;

    /**
     * The Line's constructor.
     * 
     * @param theWidth The Line's width
     * @param theInitialPoint The Line's initial point
     * @param theCurrentPoint The Line's current point
     * @param theBorderColor The Line's border color
     */
    public Line(final Point theInitialPoint, final Point theCurrentPoint, final int theWidth,
                final Color theBorderColor)
    {
        super(new Line2D.Double(), theInitialPoint, theCurrentPoint,
              theWidth, theBorderColor, Color.WHITE, false);
    }

    @Override
    public void paint()
    {
        setShape(new Line2D.Double());
        ((Line2D) getShape()).setLine(getInitialPoint(), getCurrentPoint());
    }

}
