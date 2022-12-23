package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
    public SpriteBatch batch;
    public Background background;
    public Bird bird;
    public Obstacles obstacles;
    public boolean gameOver;
    public Texture restart;

    @Override
    public void create() {
        batch = new SpriteBatch();
        background = new Background();
        bird = new Bird();
        obstacles = new Obstacles();
        gameOver = false;
        restart = new Texture("restart.png");
    }

    @Override
    public void render() {
        update();
        ScreenUtils.clear(1, 1, 1, 1);
        batch.begin();
        background.render(batch);
        obstacles.render(batch);
        if (!gameOver) {
            bird.render(batch);
        } else {
            batch.draw(restart, 200, 200);
        }
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    public void update() {
        background.update();
        bird.update();
        obstacles.update();
        for (int i = 0; i < Obstacles.obstacles.length; i++) {
            if (bird.position.x > Obstacles.obstacles[i].position.x
                    && bird.position.x < Obstacles.obstacles[i].position.x + 50) {
                if (!Obstacles.obstacles[i].emptySpace.contains(bird.position)) {
                    gameOver = true;
                }
            }
        }
        if (bird.position.y > 600 || bird.position.y < 0) {
            gameOver = true;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && gameOver) {
            recreate();
        }
    }

    public void recreate() {
        bird.recreate();
        obstacles.recreate();
        gameOver = false;
    }
}
