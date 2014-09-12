package GUI;

import Core.Main;
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
public class GuiControl extends AbstractAppState implements ScreenController {

    private Nifty nifty;
    private AppStateManager stateManager;
    private Main app;

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        this.stateManager = stateManager;
        this.app = (Main) app;
    }

    public void bind(Nifty nifty, Screen screen) {
        this.nifty = nifty;
    }

    public void onStartScreen() {

    }

    public void onEndScreen() {
        

    }
    
    public void clickPlayGame(){
        app.startGame();
        
    }
    public void clickExitGame(){
        
        app.endGame();
    }
}
