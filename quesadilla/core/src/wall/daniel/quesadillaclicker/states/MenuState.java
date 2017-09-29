package wall.daniel.quesadillaclicker.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MenuState extends State {

	public MenuState(GameStateManager gsm) {
		super(gsm);
		cam.setToOrtho(false, 600, 400);
	}

	@Override
	protected void handleInput() {
		if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER))
			gsm.set(new PlayState(gsm));
	}

	@Override
	public void update(float dt) {
		handleInput();
	}

	@Override
	public void render(SpriteBatch sb) {
		sb.begin();
		sb.end();
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
