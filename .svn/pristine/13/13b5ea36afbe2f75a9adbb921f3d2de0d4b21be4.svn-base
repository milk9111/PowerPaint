
package tools;

import java.awt.Color;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Path2D;

/**
 * Creates the Pencil Tool.
 * 
 * @author Connor Lundberg
 * @version 5/11/2016
 */
public class Pencil extends AbstractTool implements Tool
{

    /**
     * 
     */
    private static final long serialVersionUID = 5681961948184362366L;

    /** The path. */
    private Path2D myPath;
    

    /**
     * Creates the Pencil Tool.
     * 
     * @param theInitialPoint The initial point
     * @param theCurrentPoint The current point
     * @param theWidth The thickness
     * @param theBorderColor The line color
     */
    public Pencil(final Point theInitialPoint, final Point theCurrentPoint, final int theWidth,
                  final Color theBorderColor)
    {
        super(new Path2D.Double(), theInitialPoint, theCurrentPoint, theWidth, theBorderColor,
              Color.WHITE, false);
        myPath = new Path2D.Double();

    }
    
    @Override
    public void setInitialPoint(final Point thePoint)
    {
        myPath = new Path2D.Double();
        myPath.moveTo(thePoint.getX(), thePoint.getY());
    }

    @Override
    public void paint()
    {
        myPath.lineTo(getCurrentPoint().getX(), getCurrentPoint().getY());
    }
    
    @Override
    public Shape getShape()
    {
        return (Shape) myPath;
    }

}
