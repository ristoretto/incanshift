package incanshift;

import com.badlogic.gdx.Game;

public class IncanShift extends Game {

	int reqWidth = 1280;
	int reqHeight = 720;

	private IncanShift game;

	private StartScreen startScreen;
	private GameScreen gameScreen;
	private CreditScreen creditScreen;

	@Override
	public void create() {
		game = this;

		startScreen = new StartScreen(game, reqWidth, reqHeight);
		setScreen(startScreen);
	}

	public void showStartScreen() {
		setScreen(startScreen);
	}

	public void showGameScreen() {
		if (gameScreen == null) {
			gameScreen = new GameScreen(game, reqWidth, reqHeight);
		}
		setScreen(gameScreen);
	}
	
	public void showCreditScreen() {
		if (creditScreen == null) {
			creditScreen = new CreditScreen(game, reqWidth, reqHeight);
		}
		setScreen(creditScreen);
	}
}
