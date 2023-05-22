package com.example.atgmsimulator;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import com.example.atgmsimulator.components.EnemyComponents;
import com.example.atgmsimulator.components.RocketComponent;
import com.example.atgmsimulator.helpers.Helpers;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import static com.almasb.fxgl.dsl.FXGLForKtKt.*;

public class ATGMFactory implements EntityFactory {

    @Spawns("laser")
    public Entity newLaser(SpawnData data) {
        return entityBuilder(data)
                .bbox(new HitBox(BoundingShape.circle(2)))
                .at(getAppWidth() / 2.0, getAppHeight() - 100.0)
                .type(LaserType.DEFAULT_RED_LASER)
                .viewWithBBox(new Circle(3, Color.RED))
                .zIndex(1)
                .build();
    }

    @Spawns("T90M")
    public Entity newT90M(SpawnData data) {

        return entityBuilder(data)
                .at(310, 250)
                .scale(0.2, 0.2)
                .bbox(new HitBox(BoundingShape.box(50, 50)))
                .type(EnemyType.T90M)
                .collidable()
                .viewWithBBox(getAssetLoader().loadTexture(Helpers.getImage("T90M.png")))
                .with(new CollidableComponent(true), new EnemyComponents())
                .zIndex(0)
                .build();
    }

    @Spawns("rocket")
    public Entity newRocket(SpawnData data) {
        return entityBuilder(data)
                .at(100, 100)
                .bbox(new HitBox(BoundingShape.box(5, 5)))
                .scale(0.15, 0.15)
                .type(ATGMType.STUGNA)
                .viewWithBBox(getAssetLoader().loadTexture(Helpers.getImage("ATGMrocket.png")))
                .with(new CollidableComponent(true), new RocketComponent())
                .zIndex(2)
                .
                .build();
    }


}
