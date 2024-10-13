package com.test.beeline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    // Данные клиента
    private Client client = new Client("ИмяКлиента1", 200, 1335885824);

    // Обрабатываем запрос на получение меню
    @GetMapping("/{menuName}")
    public String getMenu(@PathVariable String menuName) {
        return menuService.displayMenu(menuName, client);
    }

    // Обрабатываем изменение баланса клиента
    @PostMapping("/updateBalance")
    public String updateBalance(@RequestParam int newBalance) {
        client = new Client(client.getName(), newBalance, client.getInternetTraffic());
        return "Баланс обновлен. Текущий баланс: " + client.getBalance() + " тенге.";
    }

    // Обрабатываем изменение интернет трафика клиентп
    @PostMapping("/updateTraffic")
    public String updateTraffic(@RequestParam long newTraffic) {
        client = new Client(client.getName(), client.getBalance(), newTraffic);
        return "Трафик обновлен. Текущий трафик: " + client.formatTraffic();
    }
}