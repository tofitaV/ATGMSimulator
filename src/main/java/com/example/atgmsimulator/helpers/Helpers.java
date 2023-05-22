package com.example.atgmsimulator.helpers;

import java.net.MalformedURLException;
import java.net.URL;

public class Helpers {

    public static URL getImage(String name){
        try {
            return new URL(String.format("file:///%s\\src\\main\\resources\\assets\\textures\\%s", System.getProperty("user.dir"), name));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
