package wall.daniel.quesadillaclicker.states;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import wall.daniel.quesadillaclicker.QuesadillaClicker;
import wall.daniel.quesadillaclicker.backend.fileUtils;
import wall.daniel.quesadillaclicker.sprites.building;

public class PlayState extends State {

	Texture cookie;
	BitmapFont font;
	ArrayList<building> buildings = new ArrayList<building>();
	
	float xCookie = 32f;
	float yCookie = 256f;
	float xBuildings = QuesadillaClicker.WIDTH - 128;

	double cookies = 0;
	float timeLastSave = 0;

	public PlayState(GameStateManager gsm) {
		super(gsm);
		cam.setToOrtho(false, 600, 400);

		cookie = new Texture("quesadilla.png");
		font = new BitmapFont();

		// import buildings
		buildings.add(new building(xBuildings, 32, "cursor.png", 0.2f, 10));
		buildings.add(new building(xBuildings, buildings.get(buildings.size() - 1).y +
				buildings.get(buildings.size() - 1).getImgHeight() + 16, "mexican.png", 3, 300));
		buildings.add(new building(xBuildings, buildings.get(buildings.size() - 1).y +
				buildings.get(buildings.size() - 1).getImgHeight() + 16, "cow.png", 5, 1000));
		
		buildings = fileUtils.readBuildings(buildings);
		cookies = fileUtils.readCookies();
	}

	@Override
	protected void handleInput() {
		if (Gdx.input.justTouched()) {
			if (Gdx.input.getX() > xCookie && Gdx.input.getX() < xCookie + cookie.getWidth()) {
				if (Gdx.input.getY() < QuesadillaClicker.HEIGHT - yCookie
						&& Gdx.input.getY() > QuesadillaClicker.HEIGHT - yCookie - cookie.getHeight()) {
					cookies++;
				}
			}

			for (building b : buildings) {
				if (Gdx.input.getX() > b.x && Gdx.input.getX() < b.x + b.getImgWidth()) {
					if (Gdx.input.getY() < QuesadillaClicker.HEIGHT - b.y
							&& Gdx.input.getY() > QuesadillaClicker.HEIGHT - b.y - b.getImgHeight()) {
						// Check if enough cookies to buy
						if (cookies > b.getCost()) {
							cookies -= b.getCost();
							b.increaseAmount();
						}
					}
				}
			}
		}

	}

	@Override
	public void update(float dt) {
		handleInput();

		for (building b : buildings) {
			cookies += b.getQuesadillas() * dt;
		}

		
		// Save file stuff, save every 60 seconds
		timeLastSave += dt;
		if(timeLastSave > 10) {
			timeLastSave = 0;	
			fileUtils.saveFile(buildings, cookies);
		}
	}

	@Override
	public void render(SpriteBatch sb) {
		sb.begin();
		sb.draw(cookie, xCookie, yCookie);
		font.draw(sb, Integer.toString((int) cookies), 50, 50);

		// Draw all of the buildings
		for (building b : buildings) {
			sb.draw(b.getImg(), b.x, b.y);

			// draw how many of each building right beside
			font.draw(sb, Integer.toString(b.getQuantity()), b.x + 8 + b.getImgWidth(), b.y + b.getImgHeight());
			font.draw(sb, "$" + b.getCost() + ", " + b.name, b.x,b.y);
		}
		// font.draw(sb, "x: " + Float.toString(Gdx.input.getX()), 10, 10);
		// font.draw(sb, "y: " + Float.toString(Gdx.input.getY()), 10, 30);
		sb.end();
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
