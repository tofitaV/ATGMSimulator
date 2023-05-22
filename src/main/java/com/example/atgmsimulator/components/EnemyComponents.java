package com.example.atgmsimulator.components;

import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import javafx.geometry.Point2D;

import static com.almasb.fxgl.dsl.FXGLForKtKt.getAppHeight;
import static com.almasb.fxgl.dsl.FXGLForKtKt.getAppWidth;

public class EnemyComponents extends Component {
    private Point2D velocity;

    @Override
    public void onAdded() {
        double w = FXGL.getAppWidth();
        double h = FXGL.getAppHeight();

        velocity = new Point2D(entity.getX() < w / 2 ? 1 : -1, entity.getY() < h / 2 ? 1 : -1)
                .normalize()
                .multiply(FXGLMath.random(100, 150));
    }

    @Override
    public void onUpdate(double tpf) {

      /*  int move = 1;

        if (entity.getX() <= 0 || entity.getY() <= 0) {
            move = 1;
        }else {
            move = -1;
        }

        entity.translate(velocity.multiply(tpf * move));
*//*
        if (entity.getRightX() >= getAppWidth() || entity.getBottomY() >= getAppHeight()) {
            move = -1;
        }*//*

        entity.translate(velocity.multiply(tpf * move));*/
    }
}
