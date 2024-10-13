package com.test.beeline;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Component;

import java.io.FileReader;

@Component
public class Menu {
    private JsonObject menuStructure;

    public Menu() {
        loadMenu("menu.json");
    }

    public void loadMenu(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            JsonParser parser = new JsonParser();
            this.menuStructure = (JsonObject) parser.parse(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JsonObject getMenuStructure() {
        return menuStructure;
    }

    public JsonObject getMenu(String menuName) {
        return menuStructure.getAsJsonObject("menu").getAsJsonObject(menuName);
    }
}
