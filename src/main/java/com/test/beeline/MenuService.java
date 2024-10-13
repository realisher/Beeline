package com.test.beeline;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

    @Autowired
    private Menu menu;

    public String displayMenu(String menuName, Client client) {
        JsonObject menuObject = menu.getMenu(menuName);

        // Формированик сообщения
        String message = menuObject.get("message").getAsString()
                .replace("{name}", client.getName())
                .replace("{balance}", String.valueOf(client.getBalance()))
                .replace("{traffic_gb}", String.valueOf(client.getInternetTraffic() / (1024 * 1024 * 1024)))
                .replace("{traffic_mb}", String.valueOf((client.getInternetTraffic() % (1024 * 1024 * 1024)) / (1024 * 1024)))
                .replace("{threshold}", String.valueOf(menuObject.has("threshold") ? menuObject.get("threshold").getAsInt() : 100));

        return message;
    }
}