package Core;

import AppStates.PuzzleAppState;
import GUI.GuiControl;
import com.jme3.app.SimpleApplication;
import com.jme3.niftygui.NiftyJmeDisplay;
import com.jme3.renderer.RenderManager;
import de.lessvoid.nifty.Nifty;

public class Main extends SimpleApplication {

    //Initialise the Nifty and Application variable.
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
                guiViewPort, rootNode, inputManager);

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
        
    }
    
   public void startPuzzle() {
        
        nifty.removeScreen("start");      
        PuzzleAppState puzzle = new PuzzleAppState(rootNode);
        stateManager.attach(puzzle);
    }
       
    public void endGame() {
        
        application.stop();
    }

}
