package wall.daniel.quesadillaclicker.sprites;

import com.badlogic.gdx.graphics.Texture;

public class building {

	public float x, y;
	float qps;	// Quesadillas per second
	public int quantity = 0;
	private int cost;
	public String name;
	
	private Texture img;
	
	
	public building(float x, float y, String imgPath, float qps, int cost) {
		this.x = x;
		this.y = y;
		this.qps = qps;
		this.cost = cost;
		name = imgPath.substring(0, imgPath.length() - 4);
		
		img = new Texture(imgPath);
	}
	
	public void increaseAmount() {
		quantity++;
	}
	
	public float getQuesadillas() {
		return quantity * qps;
	}
	public int getQuantity() {
		return quantity;
	}
	public int getCost() {
		return (int) (cost * Math.pow(1.1, quantity));
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
