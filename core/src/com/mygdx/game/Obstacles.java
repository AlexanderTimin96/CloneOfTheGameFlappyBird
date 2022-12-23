package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.particles.influencers.ColorInfluencer;
import com.badlogic.gdx.math.Vector2;
import com.sun.media.sound.SoftFilter;

import java.util.Random;


public class Obstacles {
    public class WallPair {
        public Vector2 position;
        public float speed;
        public int offset;

        public WallPair(Vector2 position) {
            this.position = position;
            speed = 2f;
            offset = new Random().nextInt(250);
        }

        public void update() {
            position.x -= speed;
            if (position.x < -50) {
                position.x = 800;
                offset = new Random().nextInt(250);
            }
        }
    }

    WallPair[] obstacles;
    Texture texture;
    int betweenDistatnce;

    public Obstacles() {
        texture = new Texture("wall.png");
        obstacles = new WallPair[4];
        betweenDistatnce = 250;
        int startPosition = 400;
        for (int i = 0; i < obstacles.length; i++) {
            obstacles[i] = new WallPair(new Vector2(startPosition, 0));
            startPosition += 200;
        }
    }

    public void render(SpriteBatch batch) {
        for (int i = 0; i < obstacles.length; i++) {
            batch.draw(texture, obstacles[i].position.x, obstacles[i].position.y - obstacles[i].offset);
            batch.draw(texture, obstacles[i].position.x,
                    obstacles[i].position.y + betweenDistatnce + texture.getHeight() - obstacles[i].offset);
        }
    }

    public void update() {
        for (int i = 0; i < obstacles.length; i++) {
            obstacles[i].update();
        }
    }
}
