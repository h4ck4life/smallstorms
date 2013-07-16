package edu.vanderbilt.vm.smallstorms.ui;

import android.graphics.Point;
import android.graphics.Rect;
import edu.vanderbilt.vm.smallstorms.framework.Game;
import edu.vanderbilt.vm.smallstorms.framework.Pixmap;
import edu.vanderbilt.vm.smallstorms.model.Workspace;

/**
 * Date: 7/7/13
 * Time: 3:53 AM
 */
public class Sprite {

protected Game mGame;
protected Workspace mWorkspace;

private Point mPosition;
protected Rect mBoundingBox;
protected Pixmap mCostume;

boolean mFocused;

/**
 * @param game for access to sound and graphics utilities
 * @param ws for access to other denizens of the workspace
 */
public Sprite(Game game, Workspace ws) {
    mGame = game;
    mWorkspace = ws;
}

public Sprite(Game game, Workspace ws, Pixmap costume) {
    this(game, ws);
    mPosition = new Point(0, 0);
    mCostume = costume;
    mBoundingBox = new Rect();
    adjustBoundingBox();
}

public Sprite setPosition(Point position) {
    return setPosition(position.x, position.y); }

public Sprite setPosition(int x, int y) {
    mPosition.set(x, y);
    adjustBoundingBox();
    return this; }

public int getX() { return mPosition.x; }

public int getY() { return mPosition.y; }

public Sprite setCostume(Pixmap costume) {
    mCostume = costume;
    return this; }

/**
 * Does nothing. Subclass should override if needed
 *
 * @param deltaTime since last update
 */
public void update(float deltaTime) {}

/**
 * Does nothing. Subclass should override if needed
 *
 * @param deltaTime since last update
 */
public void present(float deltaTime) {}

public boolean touches(Point point) {
    return touches(point.x, point.y);
}

public boolean touches(int x, int y) {
    return mBoundingBox.contains(x, y);
}

private void adjustBoundingBox() {
    mBoundingBox.set(
            mPosition.x - mCostume.getWidth()/2,    // left
            mPosition.y - mCostume.getHeight()/2,   // top
            mPosition.x + mCostume.getWidth()/2,    // right
            mPosition.y + mCostume.getHeight()/2);  // bottom
}

public void click() {}

public void hoverIn(Sprite hoverer) {}

public void hoverOut(Sprite hoverer) {}

public void drop(Sprite droppee) {}

public void drop(Sprite theOneAtTheBottom, Point location) {}

}
