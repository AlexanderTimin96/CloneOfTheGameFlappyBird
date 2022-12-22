package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Bird {
    private Texture birdPicture;
    private Vector2 positionBird;
    private float vy;
    private float gravity;

    public Bird() {
        this.birdPicture = new Texture("bird1.png");
        this.positionBird = new Vector2(100, 400);
        vy = 0;
        gravity = -0.3f;
    }

    public void render(SpriteBatch batch) {
        batch.draw(birdPicture, positionBird.x, positionBird.y);
    }

    public void update() {
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            vy = 5f;
        }
        vy += gravity;
        positionBird.y += vy;
    }
}
