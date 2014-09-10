/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AppStates;

import Core.Factory;
import com.jme3.app.Application;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.audio.AudioRenderer;
import com.jme3.input.FlyByCamera;
import com.jme3.input.InputManager;
import com.jme3.light.DirectionalLight;
import com.jme3.math.Vector3f;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

public class Puzzle extends AbstractAppState{

    private AssetManager assetManager;
    private InputManager inputManager;
    private AudioRenderer audioRenderer;
    private ViewPort guiViewPort;
    private Node rootNode;
    private FlyByCamera flyCam;
    
    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
       
                Factory factory = new Factory(assetManager,
                                      inputManager,
                                      audioRenderer,
                                      guiViewPort,
                                      rootNode,
                                      flyCam);
        
        
                factory.makeLinePiece();
    }
}
