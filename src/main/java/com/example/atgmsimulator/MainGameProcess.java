package com.example.atgmsimulator;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.physics.CollisionHandler;
import javafx.scene.input.KeyCode;

import java.util.Map;

import static com.almasb.fxgl.dsl.FXGLForKtKt.*;

public class MainGameProcess extends GameApplication {
    private Entity enemy;
    private Entity rocket;
    private Entity laser;


    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(1200);
        settings.setHeight(800);
        settings.setTitle("ATGM Simulator");
        settings.setVersion("0.1");
        settings.setManualResizeEnabled(true);
    }

    @Override
    protected void initInput() {
        onKey(KeyCode.D, () -> {
            laser.translateX(10);
            return null;
        });

        onKey(KeyCode.A, () -> {
            laser.translateX(-10);
            return null;
        });

        onKey(KeyCode.W, () -> {
            laser.translateY(-10);
            return null;
        });

        onKey(KeyCode.S, () -> {
            laser.translateY(10);
            return null;
        });
    }

    @Override
    protected void onUpdate(double tpf) {

        if (laser.getX() <= 0 || laser.getY() <= 0) {
            resetBall();
        }

        if (laser.getRightX() >= getAppWidth() || laser.getBottomY() >= getAppHeight()) {
            resetBall();
        }

       /* if (rocket.getX() <= 0 || rocket.getY() <= 0) {
            rocket.removeFromWorld();
        }

        if (rocket.getRightX() >= getAppWidth() || rocket.getBottomY() >= getAppHeight()) {
            rocket.removeFromWorld();
        }*/

       /* if (rocket.getX() == enemy.getRightX()
                && rocket.getY() < enemy.getBottomY()
                && rocket.getBottomY() > enemy.getY()) {
            System.out.println("GOTCHA!!!");
        }

        if (rocket.getRightX() == enemy.getX()
                && rocket.getY() < enemy.getBottomY()
                && rocket.getBottomY() > enemy.getY()) {
            System.out.println("GOTCHA!!!");
        }*/


    }

    @Override
    protected void initPhysics() {
        FXGL.getPhysicsWorld().addCollisionHandler(new CollisionHandler(ATGMType.STUGNA, EnemyType.T90M) {

            @Override
            protected void onCollisionBegin(Entity atgm, Entity enemy) {
                enemy.removeFromWorld();
            }
        });
    }

    @Override
    protected void initGameVars(Map<String, Object> vars) {
        vars.put("cordsX", 0.0);
        vars.put("cordsY", 0.0);
    }


    @Override
    protected void initGame() {
        getGameWorld().addEntityFactory(new ATGMFactory());
        laser = spawn("laser");
        rocket = spawn("rocket");
        enemy = spawn("T90M");
    }


    private void resetBall() {
        laser.setPosition(300, 300);
    }

    @Override
    protected void initUI() {
    }

    public static void main(String[] args) {
        launch(args);
    }
}