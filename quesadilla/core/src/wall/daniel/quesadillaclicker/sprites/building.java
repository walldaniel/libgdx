package wall.daniel.quesadillaclicker.sprites;

import com.badlogic.gdx.graphics.Texture;

public class building {

	public float x, y;
	float qps;	// Quesadillas per second
	int quantity = 0;
	int cost;
	
	private Texture img;
	
	
	public building(float x, float y, String imgPath, float qps, int cost) {
		this.x = x;
		this.y = y;
		this.qps = qps;
		this.cost = cost;
		
		img = new Texture(imgPath);
	}
	
	public void increaseAmount() {
		quantity++;
	}
	
	public float getQuesadillas() {
		return quantity * qps;
	}
	public int getBuildingAmount() {
		return quantity;
	}
	public int getCost() {
		return cost;
	}
	
	
	public int getImgWidth() {
		return img.getWidth();
	}
	public int getImgHeight() {
		return img.getHeight();
	}
	public Texture getImg() {
		return img;
	}
}
