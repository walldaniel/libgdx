package wall.daniel.cookieclicker.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import wall.daniel.quesadillaclicker.QuesadillaClicker;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = QuesadillaClicker.HEIGHT;
		config.width = QuesadillaClicker.WIDTH;
		new LwjglApplication(new QuesadillaClicker(), config);
	}
}
