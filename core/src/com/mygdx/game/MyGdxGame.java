package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
    SpriteBatch batch;
    Background background;
    Bird bird;

    @Override
    public void create() {
        batch = new SpriteBatch();
        background = new Background();
        bird = new Bird();
    }

    @Override
    public void render() {
        update();
        ScreenUtils.clear(1, 1, 1, 1);
        batch.begin();
        background.render(batch);
        bird.render(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    public void update() {
        background.update();
        bird.update();
    }
}
