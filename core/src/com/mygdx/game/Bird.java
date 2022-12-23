package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Bird {
    public Texture birdPicture;
    public Vector2 position;
    public float vy;
    public float gravity;

    public Bird() {
        this.birdPicture = new Texture("bird1.png");
        this.position = new Vector2(100, 400);
        vy = 0;
        gravity = -0.3f;
    }

    public void render(SpriteBatch batch) {
        batch.draw(birdPicture, position.x, position.y);
    }

    public void update() {
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            vy = 5f;
        }
        vy += gravity;
        position.y += vy;
    }

    public void recreate() {
        this.position = new Vector2(100, 400);
        vy = 0;
    }
}
