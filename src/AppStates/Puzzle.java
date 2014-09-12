package AppStates;

import Core.Factory;
import com.jme3.app.Application;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.math.Vector3f;

public class Puzzle extends AbstractAppState{
    
    private static final Vector3f positionOfPiece = new Vector3f(1,2,1);
    
    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        
        
        Factory.makeLinePiece(positionOfPiece);
        
        
    }
    @Override
    public void update(float tpf) {
    }
}
