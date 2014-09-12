
package Core;

import com.jme3.asset.AssetManager;
import com.jme3.audio.AudioRenderer;
import com.jme3.material.Material;
import com.jme3.math.Vector3f;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;

public class Factory {
    
    private static AssetManager assetManager;
    private static AudioRenderer audioRenderer;
    private static ViewPort guiViewPort;
    private static Node rootNode;
    public static final Vector3f LINE_PIECE_SIZE = new Vector3f(2.5f,2.5f,1.0f);
    
    public static void initializeFactory(AssetManager aM, 
             AudioRenderer aR, 
            ViewPort gVP, Node rN) {
        assetManager = aM;
        audioRenderer = aR;
        guiViewPort = gVP;
        rootNode = rN;
        
    }
    
    public static void makeLinePiece(Vector3f piecePosition){
        
        /*Spatial linePiece = assetManager.loadModel
                ("Models/Puzzle Pieces/Line Piece/line_piece.j3o");
        linePiece.scale(0.5f, 0.5f, 0.5f);
        linePiece.rotate(0.0f, -3.0f, 0.0f);
        linePiece.setLocalTranslation(0.0f, -5.0f, -2.0f);
        rootNode.attachChild(linePiece);
        // You must add a light to make the model visible
        DirectionalLight sun = new DirectionalLight();
        sun.setDirection(new Vector3f(-0.1f, -0.7f, -1.0f));
        rootNode.addLight(sun);*/
        
        Box box = new Box(LINE_PIECE_SIZE.x,LINE_PIECE_SIZE.y,LINE_PIECE_SIZE.z);
        Spatial wall = new Geometry("Box", box );
        Material mat_brick = new Material( 
        assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat_brick.setTexture("ColorMap", 
        assetManager.loadTexture("Textures/Terrain/BrickWall/BrickWall.jpg"));
        wall.setMaterial(mat_brick);
        wall.setLocalTranslation(piecePosition);
        rootNode.attachChild(wall);
        System.out.println("It ran");
    }
    
}
