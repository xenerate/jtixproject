package Core;

import AppStates.Puzzle;
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
    private static Main application;

    public static void main(String[] args) {
        Main app = new Main();
        application = app;
        app.setPauseOnLostFocus(false);
        app.start();
    }


    @Override
    public void simpleInitApp() {



        Factory.initializeFactory(assetManager, audioRenderer,
                guiViewPort, rootNode);

        //Start initialise nifty
        NiftyJmeDisplay niftyDisplay = new NiftyJmeDisplay(assetManager,
                inputManager,
                audioRenderer,
                guiViewPort);

        GuiControl guiControl = new GuiControl();
        stateManager.attach(guiControl);
        nifty = niftyDisplay.getNifty();
        nifty.fromXml("Interface/Nifty/gui.xml", "start", guiControl);
        guiViewPort.addProcessor(niftyDisplay);
        flyCam.setEnabled(false);
        flyCam.setDragToRotate(true);
        //End Initialise nifty

    }

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
    
    public void startGame() {
        
        nifty.removeScreen("start");      
        Puzzle puzzle = new Puzzle();
        puzzle.initialize(stateManager, (Main) application);
        flyCam.setEnabled(true);
        flyCam.setDragToRotate(true);
    }
       
    public void endGame() {
        
        application.stop();
    }
}
