package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;

public class Background {

    private class BGpicture {
        private Texture texture;
        private Vector2 position;

        public BGpicture(Vector2 position) {
            texture = new Texture("back.png");
            this.position = position;
        }
    }

    private int speed;

    private BGpicture[] backpictures;

    public Background() {
        speed = 4;
        backpictures = new BGpicture[2];
        backpictures[0] = new BGpicture(new Vector2(0, 0));
        backpictures[1] = new BGpicture(new Vector2(800, 0));
    }

    public void render(SpriteBatch batch) {
        for (int i = 0; i < backpictures.length; i++) {
            batch.draw(backpictures[i].texture, backpictures[i].position.x, backpictures[i].position.y);
        }
    }

    public void update() {
        for (int i = 0; i < backpictures.length; i++) {
            backpictures[i].position.x -= speed;
        }
        if (backpictures[0].position.x < -800) {
            backpictures[0].position.x = 0;
            backpictures[1].position.x = 800;
        }
    }
}
