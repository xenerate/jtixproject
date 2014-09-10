package GUI;

import AppStates.Puzzle;
import com.jme3.app.Application;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;

/**
 *
 * @author Student
 */
public class GuiControl extends AbstractAppState implements ScreenController{
    
    private Nifty nifty;
    private AppStateManager stateManager;
    private Application app;
    
    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        this.stateManager = stateManager;
        this.app = app;
    }
    
    public void bind(Nifty nifty, Screen screen) {
        this.nifty = nifty;
        System.out.println("bind( " + screen.getScreenId() + ")");
    }

    public void onStartScreen() {
        System.out.println("onStartScreen");

    }

    public void onEndScreen() {
        System.out.println("onEndScreen");
        Puzzle puzzle = new Puzzle();
        puzzle.initialize(stateManager, app);
        //nifty.exit();

    }
  

    
}
