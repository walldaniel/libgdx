package wall.daniel.quesadillaclicker;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import wall.daniel.quesadillaclicker.states.GameStateManager;
import wall.daniel.quesadillaclicker.states.MenuState;

public class QuesadillaClicker extends ApplicationAdapter {
	public static int WIDTH = 600;
	public static int HEIGHT = 480;
	
	SpriteBatch sb;
	GameStateManager gsm;
	
	@Override
	public void create () {
		gsm = new GameStateManager();
		sb = new SpriteBatch();
		
		gsm.push(new MenuState(gsm));
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(sb);
	}
	
	@Override
	public void dispose () {
		super.dispose();
	}
}
