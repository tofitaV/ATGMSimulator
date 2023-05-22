package com.example.atgmsimulator.components;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.entity.components.TransformComponent;
import com.example.atgmsimulator.LaserType;

public class RocketComponent extends Component {

    public static final double AMPLITUDE = 10;
    public static final double PERIOD = 2.0;
    public static final double SPEED = 100.0;
    public static final double ANGULAR_FREQUENCY = 2 * Math.PI / PERIOD;
    public double elapsedTime;
    public TransformComponent transformComponent;

    public Entity target;
    public TransformComponent targetPosition;


    @Override
    public void onAdded() {
        transformComponent = entity.getComponent(TransformComponent.class);
        elapsedTime = 0;
        target = FXGL.getGameWorld().getSingleton(LaserType.DEFAULT_RED_LASER);
        targetPosition = target.getComponent(TransformComponent.class);
    }

    @Override
    public void onUpdate(double tpf) {
        transformComponent.translateTowards(targetPosition.getPosition(), SPEED * tpf);
       /* elapsedTime += tpf;
        double newY = AMPLITUDE * Math.sin(ANGULAR_FREQUENCY * elapsedTime);
        transformComponent.setY(getAppHeight() / 2.0 + newY + ANGULAR_FREQUENCY);*/

    }


}
