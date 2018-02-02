
package gui;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * This is the class containing the main method that starts the PowerPaint
 * application.
 * 
 * @author Connor Lundberg
 * @version 5/3/2016
 */
public final class PowerPaintMain
{
    /**
     * Private constructor, to prevent instantiation of this class.
     */
    private PowerPaintMain()
    {
        throw new IllegalStateException();
    }

    /**
     * The main method, invokes the SnapShop GUI. Command line arguments are
     * ignored.
     * 
     * @param theArgs Command line arguments.
     */
    public static void main(final String[] theArgs)
    {
        try
        {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        }
        catch (final UnsupportedLookAndFeelException e)
        {
            e.printStackTrace();
        }
        catch (final ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (final InstantiationException e)
        {
            e.printStackTrace();
        }
        catch (final IllegalAccessException e)
        {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new PowerPaintGUI().start();
            }
        });
    }
}
