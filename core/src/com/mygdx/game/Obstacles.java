package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;


public class Obstacles {
    public class WallPair {
        public Vector2 position;
        public float speed;
        public int offset;
        public Rectangle emptySpace;

        public WallPair(Vector2 position) {
            this.position = position;
            speed = 3f;
            offset = new Random().nextInt(250);
            emptySpace = new Rectangle(position.x, position.y + texture.getHeight() - offset, 50, betweenDistatance);
        }

        public void update() {
            position.x -= speed;
            if (position.x < -50) {
                position.x = 800;
                offset = new Random().nextInt(250);
            }
            emptySpace.x = position.x;
        }
    }

    public static WallPair[] obstacles;
    public Texture texture;
    public int betweenDistatance;

    public Obstacles() {
        texture = new Texture("wall.png");
        obstacles = new WallPair[4];
        betweenDistatance = 250;
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
                   obstacles[i].position.y + betweenDistatance + texture.getHeight() - obstacles[i].offset);
        }
    }

    public void update() {
        for (int i = 0; i < obstacles.length; i++) {
            obstacles[i].update();
        }
    }

    public void recreate() {
        int startPosition = 400;
        for (int i = 0; i < obstacles.length; i++) {
            obstacles[i] = new WallPair(new Vector2(startPosition, 0));
            startPosition += 200;
        }
    }
}
