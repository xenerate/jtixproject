
package Core;

import com.jme3.asset.AssetManager;
import com.jme3.audio.AudioRenderer;
import com.jme3.input.InputManager;
import com.jme3.light.DirectionalLight;
import com.jme3.math.Vector3f;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

public class Factory {
    
    private static AssetManager assetManager;
    private static AudioRenderer audioRenderer;
    private static ViewPort guiViewPort;
    private static Node rootNode;
    private static InputManager inputManager;
    
    public static final Vector3f LINE_PIECE_LIGHT = 
            new Vector3f(-0.1f,-0.7f,-1.0f);
    public static final Float LINE_PIECE_SCALE = 0.5f;
    public static final Vector3f LINE_PIECE_SIZE = 
            new Vector3f(2.5f,2.5f,1.0f);
    public static final Vector3f LINE_PIECE_ROTATE = 
            new Vector3f(0.0f,0.0f,0.0f);
    
    public static void initializeFactory(AssetManager aM, 
             AudioRenderer aR, 
            ViewPort gVP, Node rN, InputManager iM) {
        assetManager = aM;
        audioRenderer = aR;
        guiViewPort = gVP;
        rootNode = rN;
        inputManager = iM;
    }
    
    public static Spatial makeLinePiece(Vector3f piecePosition, Node nodePlace){
        
        Spatial linePiece = assetManager.loadModel
                ("Models/Puzzle Pieces/Line Piece/line_piece.j3o");
        linePiece.scale(LINE_PIECE_SCALE);
        linePiece.rotate
                (LINE_PIECE_ROTATE.x,LINE_PIECE_ROTATE.y,LINE_PIECE_ROTATE.z);
        linePiece.setLocalTranslation(piecePosition);
        linePiece.setName("Line Piece");
        DirectionalLight sun = new DirectionalLight();
        sun.setDirection(new Vector3f(LINE_PIECE_LIGHT));
        nodePlace.addLight(sun);
 
        
        return linePiece;

        
        
    }  
            

}
