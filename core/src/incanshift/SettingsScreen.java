package incanshift;

import com.badlogic.gdx.Input.Keys;

public class SettingsScreen extends AbstractMenuScreen {

	private MenuItem back;
	private MenuItem keyUse;
	private MenuItem keyFire;
	private MenuItem keyRun;
	private MenuItem keyJump;
	private MenuItem keyStrafeLeft;
	private MenuItem keyStrafeRight;
	private MenuItem keyBackward;
	private MenuItem keyForward;

	boolean capturing = false;

	public SettingsScreen(IncanShift game, int reqWidth, int reqHeight) {
		super(game, reqWidth, reqHeight, "sound/music_menu.ogg");

		back = new MenuItem("Back", null, true);
		keyUse = new MenuItem("Use/Pick Up:", Keys.toString(GameSettings.USE),
				true);
		keyFire = new MenuItem("Fire/Throw:", "Left Mouse", false);
		keyRun = new MenuItem("Run:", Keys.toString(GameSettings.RUN), true);
		keyJump = new MenuItem("Jump:", Keys.toString(GameSettings.JUMP), true);
		keyStrafeLeft = new MenuItem("Strafe Left:",
				Keys.toString(GameSettings.STRAFE_LEFT), true);
		keyStrafeRight = new MenuItem("Strafe Right:",
				Keys.toString(GameSettings.STRAFE_RIGHT), true);
		keyBackward = new MenuItem("Move Backward:",
				Keys.toString(GameSettings.BACKWARD), true);
		keyForward = new MenuItem("Move Forward:",
				Keys.toString(GameSettings.FORWARD), true);

		Menu menu = new Menu();
		menu.add(back);
		menu.add(keyUse);
		menu.add(keyRun);
		menu.add(keyJump);
		menu.add(keyStrafeLeft);
		menu.add(keyStrafeRight);
		menu.add(keyBackward);
		menu.add(keyForward);
		menu.add(keyFire);

		setMenu(menu, back);
	}

	public void enterSelected() {

		if (selectedItem == back) {
			game.showStartScreen();

		} else if (selectedItem.selectable) {
			itemValueSelected = true;
			capturing = true;
		}

	}

	@Override
	boolean keyDownCapture(int keycode) {
		if (!capturing) {
			return false;
		}

		if (selectedItem == keyUse) {
			GameSettings.USE = keycode;
		}
		if (selectedItem == keyRun) {
			GameSettings.RUN = keycode;
		}
		if (selectedItem == keyJump) {
			GameSettings.JUMP = keycode;
		}
		if (selectedItem == keyStrafeLeft) {
			GameSettings.STRAFE_LEFT = keycode;
		}
		if (selectedItem == keyStrafeRight) {
			GameSettings.STRAFE_RIGHT = keycode;
		}
		if (selectedItem == keyBackward) {
			GameSettings.BACKWARD = keycode;
		}
		if (selectedItem == keyForward) {
			GameSettings.FORWARD = keycode;
		}

		itemValueSelected = false;
		capturing = false;

		// Redraw settings menu
		selectedItem.value = Keys.toString(keycode);
		menu.dispose();
		createMenuTextures();
		game.showSettingsScreen();

		return true;
	}

	@Override
	boolean keyTypedCapture(char character) {
		return capturing;
	}

	@Override
	boolean mouseMovedCapture(int screenX, int screenY) {
		return capturing;
	}

	@Override
	boolean touchDownCapture(int screenX, int screenY) {
		return capturing;
	}

}
