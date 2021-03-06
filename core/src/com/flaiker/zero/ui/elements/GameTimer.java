/******************************************************************************
 * Copyright 2016 Fabian Lupa                                                 *
 ******************************************************************************/

package com.flaiker.zero.ui.elements;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.flaiker.zero.ui.screens.AbstractScreen;

import java.util.concurrent.TimeUnit;

/**
 * Timer element of the game, wraps a {@link TextButton} which can be added to the ingame ui
 */
public class GameTimer {
    private TextButton timerButton;
    private long       gameTimeMillis;

    public GameTimer(Skin skin) {
        gameTimeMillis = 0L;
        timerButton = new TextButton("TIME", skin);
        timerButton.setWidth(200f);
        timerButton.setPosition(AbstractScreen.SCREEN_WIDTH / 2 - timerButton.getWidth() / 2,
                                AbstractScreen.SCREEN_HEIGHT - timerButton.getHeight());
        timerButton.setDisabled(true);
    }

    public TextButton getTimerButton() {
        return timerButton;
    }

    public void updateTime(float delta) {
        gameTimeMillis += delta * 1000f;
        String formattedTime = String.format("%02d:%02d", TimeUnit.MILLISECONDS.toMinutes(gameTimeMillis),
                                             TimeUnit.MILLISECONDS.toSeconds(gameTimeMillis) -
                                             TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
                                                                                .toMinutes(gameTimeMillis)));
        timerButton.setText(formattedTime);
    }
}
