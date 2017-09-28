package states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PlayState extends State {
	
	Texture cookie;
	BitmapFont font;
	
	float xCookie = 32f;
	float yCookie = 256f;
	
	int cookies = 0;

	public PlayState(GameStateManager gsm) {
		super(gsm);
		cam.setToOrtho(false, 600, 400);
		
		cookie = new Texture("cookie.png");
		font = new BitmapFont();
	}

	@Override
	protected void handleInput() {
		if(Gdx.input.justTouched()) 
			if(Gdx.input.getX() > xCookie && Gdx.input.getX() < xCookie + cookie.getWidth()) 
				if(Gdx.input.getY() > yCookie && Gdx.input.getY() < yCookie + cookie.getHeight()) 
					cookies++;
		
		
	}

	@Override
	public void update(float dt) {
		handleInput();
		
		if() {
			
		}
	}

	@Override
	public void render(SpriteBatch sb) {
		sb.begin();
		sb.draw(cookie, xCookie, yCookie);
		font.draw(sb, Integer.toString(cookies), 50, 50);
		sb.end();
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
