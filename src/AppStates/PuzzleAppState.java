package AppStates;

import Core.Factory;
import com.jme3.renderer.Camera;
import com.jme3.app.Application;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.bullet.collision.PhysicsCollisionEvent;
import com.jme3.bullet.collision.PhysicsCollisionListener;
import com.jme3.collision.CollisionResults;
import com.jme3.input.InputManager;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.MouseButtonTrigger;
import com.jme3.math.Ray;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

public class PuzzleAppState extends AbstractAppState implements PhysicsCollisionListener{
    
    private static final Vector3f positionOfPiece = new Vector3f(0.0f, -5.0f, -2.0f);
    private static final Vector3f CAM_POSITION = new Vector3f(0f,-5f,15f);
    private Camera puzzleCam;
    private InputManager inputManager;
    private AssetManager assetManager;

    private Node puzzleNode = new Node();
   
   
    public PuzzleAppState(Node rootNode){
        
        rootNode.attachChild(puzzleNode);
    }
    
    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        
        inputManager = app.getInputManager();
        puzzleCam = app.getCamera();
        assetManager = app.getAssetManager();
 
        
        puzzleCam.setLocation(CAM_POSITION);
        linePiece();

        
        inputManager.addMapping("Select", new MouseButtonTrigger(MouseInput.BUTTON_LEFT));
        inputManager.addListener(actionListener, "Select");
        inputManager.setCursorVisible(true);
        
    }
    @Override
    public void update(float tpf) {
        
    }
    
    public void linePiece(){
        
        Spatial linePiece;
        linePiece = Factory.makeLinePiece(positionOfPiece, puzzleNode);
        puzzleNode.attachChild(linePiece);
    }

    public void collision(PhysicsCollisionEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
            private ActionListener actionListener = new ActionListener(){
        public void onAction(String name, boolean isPressed, float tpf) {
            if(name.equals("Select")){
                
                    CollisionResults results = new CollisionResults();
                Vector2f click2d = inputManager.getCursorPosition();
                Vector3f click3d = puzzleCam.getWorldCoordinates(
                        new Vector2f(click2d.x,click2d.y), 0f).clone();
                Vector3f dir = puzzleCam.getWorldCoordinates(
                        new Vector2f(click2d.x, click2d.y),1f).
                        subtractLocal(click3d).normalizeLocal();
                //Converts screen click to a 3D Position
                Ray ray = new Ray(click3d,dir);
                puzzleNode.collideWith(ray, results);
                //Aim the ray from where the click happened in a forward direction
                for (int i = 0; i < results.size(); i++) {
                    float distance = results.getCollision(i).getDistance();
                    Vector3f pt = results.getCollision(i).getContactPoint();
                    String target = results.getCollision(i).getGeometry().getName();
                }
                if(results.size() > 0 && !isPressed){
                    Geometry target = results.getClosestCollision().getGeometry();                  
                    if(target.getName().equals("Line Piece")){
                        System.out.println("HERE");
                    }
                }
            }
        }
    };
}
