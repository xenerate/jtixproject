
package Core;

import com.jme3.asset.AssetManager;
import com.jme3.audio.AudioRenderer;
import com.jme3.input.FlyByCamera;
import com.jme3.input.InputManager;
import com.jme3.light.DirectionalLight;
import com.jme3.math.Vector3f;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

public class Factory {
    
    private AssetManager assetManager;
    private InputManager inputManager;
    private AudioRenderer audioRenderer;
    private ViewPort guiViewPort;
    private Node rootNode;
    private FlyByCamera flyCam;
    
    public Factory(AssetManager assetManager, InputManager inputManager,
                   AudioRenderer audioRenderer, ViewPort guiViewPort,
                   Node rootNode, FlyByCamera flyCam){
        
        this.assetManager = assetManager;
        this.inputManager = inputManager;
        this.audioRenderer = audioRenderer;
        this.guiViewPort = guiViewPort;
        this.flyCam = flyCam;
        this.rootNode = rootNode;
        
    }
    
    public void makeLinePiece(){
        
        flyCam.setEnabled(true);
        flyCam.isDragToRotate();
        flyCam.setMoveSpeed(15f);
        
        Spatial linePiece = assetManager.loadModel("Models/Puzzle Pieces/Line Piece/line_piece.j3o");
        linePiece.scale(0.5f, 0.5f, 0.5f);
        linePiece.rotate(0.0f, -3.0f, 0.0f);
        linePiece.setLocalTranslation(0.0f, -5.0f, -2.0f);
        rootNode.attachChild(linePiece);
        // You must add a light to make the model visible
        DirectionalLight sun = new DirectionalLight();
        sun.setDirection(new Vector3f(-0.1f, -0.7f, -1.0f));
        rootNode.addLight(sun);
        
    }
    
}
