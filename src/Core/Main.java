package Core;

import GUI.GuiControl;
import com.jme3.app.SimpleApplication;
import com.jme3.niftygui.NiftyJmeDisplay;
import com.jme3.renderer.RenderManager;
import de.lessvoid.nifty.Nifty;

/**
 * Written By Imran Kaba & Julian Palmieri
 */
public class Main extends SimpleApplication {

    //Initialise Nifty variable.
    private Nifty nifty;
    
    public static void main(String[] args) {
        Main app = new Main();
        app.setPauseOnLostFocus(false);
        app.start();
    }

    @Override
    public void simpleInitApp() {
        
        NiftyJmeDisplay niftyDisplay = new NiftyJmeDisplay(assetManager,
                                                          inputManager,
                                                          audioRenderer,
                                                          guiViewPort);                                                         
        GuiControl guiControl = new GuiControl();
        
        nifty = niftyDisplay.getNifty();
        nifty.fromXml("Interface/Nifty/gui.xml", "start", guiControl);
        nifty.fromXml("Interface/Nifty/gui.xml", "end", guiControl);

        guiViewPort.addProcessor(niftyDisplay);

        flyCam.setEnabled(false);
        flyCam.setDragToRotate(true);
        
        
    }

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
