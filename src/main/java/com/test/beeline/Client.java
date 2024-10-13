package com.test.beeline;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Client {
    private String name;
    private int balance;
    private long internetTraffic;



    // Форматирование трафика
    public String formatTraffic() {
        long trafficGB = internetTraffic / (1024 * 1024 * 1024);
        long trafficMB = (internetTraffic % (1024 * 1024 * 1024)) / (1024 * 1024);
        return trafficGB + " ГБ " + trafficMB + " МБ";
    }
}